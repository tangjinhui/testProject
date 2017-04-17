$("#province").change(function(){
	var province = $("#province").val();
	loadCity(province);
	
})

function copy(){
	var id =$('input[name="id"]:checked').val();
	alert(id);
}

/**
 * 校验长度为只能输入100，多了不让输入，可以删除
 */
$('#input').on('keydown',function(e){
	   var _that = $(this);
	   if(_that[0].value.length >100){
		   //e.keyCode获取到是键值。
		   if(e.keyCode==8){
			   return true
		   }else{
			   return false 
		   }
	   }
	})
	
/**
 * 失去焦点：去除字符串的前后空格
 */
$('#input').bind("blur",function(e){
	var value = $('#input').val().trim().replace(" ", "");
	alert("1>" + value + "<");
	alert(value.length)
})

	
	
 function loadCity(msg){
	 $.ajax({
		 url:"/test/city/city.do",
		 type:"get",
		 data:{"pid":msg},
		 dataType:"text",
		 success:function(msg){
			 if (msg == "[]") {
			        $("#city").empty();
			        $("<option value='0'>请输入城市</option>").appendTo($("#city"))
			      } else {
			        $("#city").empty();
			        data = JSON.parse(msg);
			        /*$("<option value='' selected='selected' >请选择市</option>").appendTo($("#district_id"));*/
			        for (var i = 0; i < data.length; i++) {
			          $("<option value='" + data[i].cid + "'>" + data[i].cname
			                  + "</option>").appendTo($("#city"));
			        }
			        chushihua()
			  }
		 }
		 
	 });
 }
$("#city").change(function(){
	var province = $("#city").val();
	loadCity1(province);
	
})
function chushihua(){
	if($("#city").val()!=''){
		
		loadCity1($("#city").val())
	}
}

 function loadCity1(msg){
	 $.ajax({
		 url:"/test/qu/qu.do",
		 type:"post",
		 data:{"cid":msg},
		 dataType:"text",
		 success:function(msg){
			 if (msg == "[]") {
			        $("#qu").empty();
			        $("<option value='0'>请输入城市</option>").appendTo($("#qu"))
			      } else {
			        $("#qu").empty();
			        data = JSON.parse(msg);
			        /*$("<option value='' selected='selected' >请选择市</option>").appendTo($("#district_id"));*/
//			        for (var i = 0; i < data.length; i++) {
//			          $("<option value='" + data[i].qid + "'>" + data[i].qname
//			                  + "</option>").appendTo($("#qu"));
//			        }
			        $.each(data,function(i,e){
			        	$("<option value='"+data[i].qid+"'>"+data[i].qname+"</option>").appendTo($("#qu"));
			        });
			  }
		 }
		 
	 });
 }