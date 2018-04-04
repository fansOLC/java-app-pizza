function addInfo(e){
	$.ajax({
		url:"dataRegister",
		dataType:"json",
		type:"POST",
		data:$('#dataForm').serialize(),
		success:function(data){
			console.log("start-----");
			console.log(data);
			if(data.state=="success"){
				$("#dataForm")[0].reset();
				layer.msg("数据提交成功！");
			}else{
				layer.msg("提交失败！");
			}
		},
		error:function(){
			alert("请求出现错误！");
		}
	});
}

$(function(){
	//加载作案方式
	getMethod("getZafs",getZafs);
	//加载诈骗手段分类
	getMethod("getZpsdfl",getZpsdfl);
	$.ajax({
		url:"testAjax",
		dataType:"json",
		success:function(data){
			console.log(data);
		}
	});
});

//获取作案手段和诈骗手段分类
function getMethod(url,successMethod){
	$.ajax({
		url:url,
		dataType:"json",
		success:function(data){
			successMethod(data);
		},
		error:function(){
			alert('error');
		}
	});
	
}

$('#zpsdfl').change(function(){
	var zpsdCode=$('#zpsdfl').val();
	//加载诈骗手段大类
	changeAjax("getZpsddl",getZpsddl,zpsdCode);
});

$('#zpsddl').change(function(){
	var zpsdCode=$('#zpsddl').val();
	//加载诈骗手段小类
	changeAjax("getZpsdxl",getZpsdxl,zpsdCode);
});

//分类与大类变化后的ajax函数
function changeAjax(url,successMethod,zpsdCode){
	$.ajax({
		url:url,
		dataType:"json",
		//type:"POST",
		data:{"zpsdCode":zpsdCode},
		success:function(data){
			successMethod(data);
		},
		error:function(){
			alert('error');
		}
	});
}

//获取作案方式成功
function getZafs(data){
	getZafsZpsdfl(data,'zafs',"methodCode","methodName");
	
}

//获取诈骗手段分类成功
function getZpsdfl(data){
	getZafsZpsdfl(data,'zpsdfl',"zpsdCode","zpsdName");
	
}

//获取作案方式成功、获取诈骗手段分类成功
function getZafsZpsdfl(data,id,valFirstName,valLastName){
	if(data){
		$("#"+id).empty();
		$("#"+id).append("<option value=''>请选择</option>");
		$.each(data,function(i){
			$("#"+id).append("<option value='"+data[i][valFirstName]+"'>"+data[i][valLastName]+"</option>");
		});
		$('.selectpicker').selectpicker('refresh');
	}
}

//获取诈骗手段大类成功
function getZpsddl(data){
	$("#zpsddl").empty();
	$('#zpsddl').append("<option value=''>请选择</option>");
	$("#zpsdxl").empty();
	$('#zpsdxl').append("<option value=''>请选择</option>");
	if(data && data.length>0){
		$("#zpsddl").empty();
		$('#zpsddl').append("<option value=''>请选择</option>");
		$.each(data,function(i){
			$('#zpsddl').append("<option value='"+data[i].zpsdCode+"'>"+data[i].zpsdName+"</option>");
		});
		$('.selectpicker').selectpicker('refresh');
	}
	if(data && data.length==0){
		var val=$('#zpsdfl').val();
		if(val==""){
			$("#zpsddl").empty();
			$("#zpsdxl").empty();
			$('#zpsddl').append("<option value=''>请选择</option>");
			$('#zpsdxl').append("<option value=''>请选择</option>");
			$('.selectpicker').selectpicker('refresh');
			return;
		}
		var presendVal=$('#zpsdfl>option[value='+val+']').text();
		$("#zpsddl").empty();
		$("#zpsdxl").empty();
		$('#zpsddl').append("<option value='"+val+"'>"+presendVal+"</option>");
		$('#zpsdxl').append("<option value='"+val+"'>"+presendVal+"</option>");
		$('.selectpicker').selectpicker('refresh');
	}
}

//获取诈骗手段小类成功
function getZpsdxl(data){
	if(data && data.length>0){
		$("#zpsdxl").empty();
		$('#zpsdxl').append("<option value=''>请选择</option>");
		$.each(data,function(i){
			$('#zpsdxl').append("<option value='"+data[i].zpsdCode+"'>"+data[i].zpsdName+"</option>");
		});
		$('.selectpicker').selectpicker('refresh');
	}
	if(data && data.length==0){
		var val=$('#zpsddl').val();
		if(val==""){
			$("#zpsdxl").empty();
			$('#zpsdxl').append("<option value=''>请选择</option>");
			$('.selectpicker').selectpicker('refresh');
			return;
		}
		var presendVal=$('#zpsddl>option[value='+val+']').text();
		$("#zpsdxl").empty();
		$('#zpsdxl').append("<option value='"+val+"'>"+presendVal+"</option>");
		$('.selectpicker').selectpicker('refresh');
	}
}
