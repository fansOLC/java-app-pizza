function addInfo(e){
	var formData = new FormData($("#dataForm")[0]);
	formData.append("olc",'22');
	console.log(formData.get('olc'));
	console.log(formData);
	var url="add_suspect";
	var type="POST";
	//var data=$('#dataForm').serialize();
	var callback=function(res){
		if(res&&res.state=="success"){
			$('#dataForm')[0].reset();
			layer.msg("登记成功");
		}else{
			layer.msg("登记失败");
		}
	}
	loadAjaxData(url,type,formData,callback);
}

function loadAjaxData(url,type,data,callback){
	$.ajax({
		url:url,
		dataType:'json',
		type:type,
		data:data,
		async: false,
		cache : false,
		contentType: false, //必须
        processData: false, //必须
		success:function(res){
			callback(res);
		}
	});
}