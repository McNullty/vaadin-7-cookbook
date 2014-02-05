package com.analemma.drag_and_drop_uplad;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.vaadin.event.dd.DragAndDropEvent;
import com.vaadin.event.dd.DropHandler;
import com.vaadin.event.dd.acceptcriteria.AcceptAll;
import com.vaadin.event.dd.acceptcriteria.AcceptCriterion;
import com.vaadin.server.StreamVariable;
import com.vaadin.ui.DragAndDropWrapper;
import com.vaadin.ui.DragAndDropWrapper.WrapperTransferable;
import com.vaadin.ui.Html5File;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.ProgressIndicator;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class DragAndDropUploader extends VerticalLayout {
	private static final String REPOSITORY = "c:\\vaadin-repo\\";

	public DragAndDropUploader() {
		final Table table = new Table();
		table.setSizeFull();
		table.addContainerProperty("File name", String.class, null);
		table.addContainerProperty("Size", String.class, null);
		table.addContainerProperty("Progress", ProgressIndicator.class, null);

		DragAndDropWrapper dropTable = new DragAndDropWrapper(table);

		dropTable.setDropHandler(new DropHandler() {

			@Override
			public AcceptCriterion getAcceptCriterion() {
				return AcceptAll.get();
			}

			@Override
			public void drop(DragAndDropEvent event) {
				WrapperTransferable transferred = (WrapperTransferable) event
						.getTransferable();
				Html5File files[] = transferred.getFiles();
				if (files != null) {
					for (final Html5File file : files) {
						ProgressIndicator indicator = new ProgressIndicator();
						indicator.setPollingInterval(100);
						indicator.setSizeFull();
						table.addItem(
								new Object[] { file.getFileName(),
										getSizeAsString(file.getFileSize()),
										indicator }, null);

						StreamVariable streamVariable = createStreamVariable(
								file, indicator);
						file.setStreamVariable(streamVariable);
					}
				} else {
					Notification.show("Unsupported object", Type.ERROR_MESSAGE);
				}
			}
		});

		addComponent(dropTable);
		setSizeUndefined();
	}

	private StreamVariable createStreamVariable(final Html5File file,
			final ProgressIndicator indicator) {
		final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		return new StreamVariable() {

			public OutputStream getOutputStream() {
				return outputStream;
			}

			public boolean listenProgress() {
				return true;
			}

			public void onProgress(StreamingProgressEvent event) {
				indicator.setValue((float) event.getBytesReceived()
						/ file.getFileSize());
			}

			public void streamingStarted(StreamingStartEvent event) {
			}

			public void streamingFinished(StreamingEndEvent event) {
				try {
					FileOutputStream fos = new FileOutputStream(REPOSITORY
							+ file.getFileName());
					outputStream.writeTo(fos);
				} catch (IOException e) {
					Notification.show("Streaming finished failed",
							Type.ERROR_MESSAGE);
				}
				indicator.setValue(new Float(1.0));
			}

			public void streamingFailed(StreamingErrorEvent event) {
				Notification.show("Streaming failed", Type.ERROR_MESSAGE);
			}

			public boolean isInterrupted() {
				return false;
			}
		};
	}

	private String getSizeAsString(long size) {
		String unit = "B";
		if (size > 1024) {
			size = size / 1024;
			unit = "kB";
		}

		if (size > 1024) {
			size = size / 1024;
			unit = "MB";
		}

		return size + " " + unit;
	}
}
