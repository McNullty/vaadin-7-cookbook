package com.analemma.vaadin_mvp.presenter.tag;

import java.util.List;

import com.analemma.vaadin_mvp.model.ServiceException;
import com.analemma.vaadin_mvp.model.tag.Tag;
import com.analemma.vaadin_mvp.model.tag.TagService;
import com.analemma.vaadin_mvp.view.tag.TagView;
import com.analemma.vaadin_mvp.view.tag.TagViewHandler;
import com.vaadin.ui.TextField;

public class TagPresenter implements TagViewHandler {

  private final TagView tagView;
  private final TagService tagService;

  public TagPresenter(final TagView tagView, final TagService tagService) {
    this.tagView = tagView;
    this.tagService = tagService;
  }

  @Override
  public void addTag() {
    final TextField txtTagName = tagView.getNewTagLayout().getTxtTagName();
    final String value = txtTagName.getValue();

    try {
      final Tag tag = new Tag(value);
      tagService.save(tag);
      tagView.getNewTagLayout().afterSuccessfulSave();

      showTagList();
    } catch (final ServiceException e) {
      // TODO: log the exception
      // TODO: notify view about failure
    }
  }

  @Override
  public void showTagList() {
    try {
      final List<Tag> tags = tagService.findAll();
      tagView.getTagListLayout().afterSuccessfulFetch(tags);
    } catch (final ServiceException e) {
      // TODO: log the exception
      // TODO: notify view about failure
    }
  }
}
