window.com_analemma_high_charts_Highcharts = function() {

	this.onStateChange = function() {
		var chart = new Highcharts.Chart(this.getState().data);
	};
};