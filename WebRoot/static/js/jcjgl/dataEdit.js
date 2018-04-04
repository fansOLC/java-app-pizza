var zafs,zpsdfl,zpsddl,zpsdxl;
$(function(){
	if(id){
		$.ajax({
			url:"getInfoById",
			type:"POST",
			dataType:"json",
			data:{infoId:id},
			success:function(data){
				zafs=data.zafs;
				zpsdfl=data.zasdfl;
				zpsddl=data.zasddl;
				zpsdxl=data.zasdxl;
				$('input[name="id"]').val(data.id);
				$('input[name="jjdbh"]').val(data.jjdbh);
				$('input[name="bpzje"]').val(data.bpzje);
				$('input[name="gjz"]').val(data.gjz);
				$('input[name="bjsj"]').val(data.bjsj_format);
				$('input[name="jjy"]').val(data.jjy);
				$('input[name="bjdh"]').val(data.bjdh);
				$('input[name="bjrxm"]').val(data.bjrxm);
				$('input[name="dw"]').val(data.dw);
				$('input[name="afdz"]').val(data.afdz);
				$('textarea[name="bjnr"]').val(data.bjnr);
				selectVal("bjrxb",data.bjrxb)
				//加载作案方式
				getMethod("getZafs",getZafs);
				//加载诈骗手段分类
				getMethod("getZpsdfl",getZpsdfl);
				//加载诈骗手段大类
				if(data.zasddl==data.zasdfl && data.zasdxl==data.zasdfl){
					getZpsdDlXl("zpsddl","getZpsdfl","",zpsdfl);
					getZpsdDlXl("zpsdxl","getZpsdfl","",zpsdfl);
				}else if(data.zasddl==data.zasdxl){
					getZpsdDlXl("zpsddl","getZpsddl",data.zasdfl,zpsddl);
					getZpsdDlXl("zpsdxl","getZpsddl",data.zasdfl,zpsddl);
				}else{
					getZpsdDlXl("zpsddl","getZpsddl",data.zasdfl,zpsddl);
					getZpsdDlXl("zpsdxl","getZpsdxl",data.zasddl,zpsdxl);
				}
			}
		});
	}
})

//作案方式||单位名称
    function selectVal($id,val){
    	var opts=$('#'+$id+'>option');
    	$.each(opts,function(i){
    		if(opts[i].value==val){
    			opts[i].selected="selected";
    			return;
    		}
    	});
    }

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

//获取诈骗手段大类与小类
function getZpsdDlXl(id,url,zpsdCode,selfCode){
	$.ajax({
		url:url,
		dataType:"json",
		data:{"zpsdCode":zpsdCode},
		success:function(data){
			$.each(data,function(i){
				$("#"+id).append("<option value='"+data[i].zpsdCode+"'>"+data[i].zpsdName+"</option>");
			});
			selectVal(id,selfCode);
			$('.selectpicker').selectpicker('refresh');
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
	getZafsZpsdfl(data,'zafs',"methodCode","methodName",zafs);
}

//获取诈骗手段分类成功
function getZpsdfl(data){
	getZafsZpsdfl(data,'zpsdfl',"zpsdCode","zpsdName",zpsdfl);
}


//获取作案方式成功、获取诈骗手段分类成功
function getZafsZpsdfl(data,id,valFirstName,valLastName,type){
	if(data){
		$("#"+id).empty();
		$("#"+id).append("<option value=''>请选择</option>");
		$.each(data,function(i){
			$("#"+id).append("<option value='"+data[i][valFirstName]+"'>"+data[i][valLastName]+"</option>");
		});
		selectVal(id,type);
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

//提交修改数据
function addInfo(e){
	$.ajax({
		url:"updateData",
		dataType:"json",
		type:"POST",
		data:$('#dataForm').serialize(),
		success:function(data){
			if(data.state=="success"){
				layer.msg("数据提交成功！",{icon:1,time:1000},function(){
					window.parent.page(window.parent.pageIndex);//刷新父页面(调用父页面方法)
					var index = parent.layer.getFrameIndex(window.name);  
					parent.layer.close(index);
				});
				 
			}else{
				layer.msg("提交失败！");
			}
		},
		error:function(){
			alert("请求出现错误！");
		}
	});
}