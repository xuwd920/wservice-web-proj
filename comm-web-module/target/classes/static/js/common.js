function timeStampAll(StatusMinute) {
	var day = parseInt(StatusMinute / 60 / 24);
	var hour = parseInt(StatusMinute / 60 % 24);
	var min = parseInt(StatusMinute % 60);
	StatusMinute = "";
	if (day > 0) {
		StatusMinute = day + "天";
	}
	if (hour > 0) {
		StatusMinute += hour + "小时";
	}
	if (min > 0) {
		StatusMinute += parseFloat(min) + "分钟";
	}
	return StatusMinute;
}

function timeStamp(StatusMinute) {
	var day = parseInt(StatusMinute / 60 / 24);
	var hour = parseInt(StatusMinute / 60 % 24);
	var min = parseInt(StatusMinute % 60);
	StatusMinute = "";
	if (day > 0) {
		StatusMinute = day + "天";
	}
	if (hour > 0) {
		StatusMinute += hour + "小时";
	}
	if (day<1 && min > 0) {
		StatusMinute += parseFloat(min) + "分钟";
	}
	return StatusMinute;
}