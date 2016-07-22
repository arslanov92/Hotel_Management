
function example()
{
    var response = ""; 
    var formData = {
            'CheckDate'              : $('input[name=CheckDate]').val(),
            'CheckOutDate'             : $('input[name=CheckOutDate]').val()
        };   
    $.ajax({
        type: "get", 
        url: "api/freeRoom", 
        data: formData,
                
        success: function(response)
        {
            console.log(response);
            
//	    var json_obj = $.parseJSON(response);//parse JSON
            var json_obj = response;
            
//            var output="<ul>";
//            for (var i in json_obj) 
//            {
//                output+="<li>" +"RoomId: " + json_obj[i].roomId + ",  " +"Room Number: "+ json_obj[i].roomNumber + ",  " 
//                        + "RoomBed: "+json_obj[i].bed + ",  " +"RoomPrice: "+ json_obj[i].price + ",  " 
//                        +"TypeRoom: "+ json_obj[i].typeRoom + "</li>" ;
//            }
//            output+="</ul>";
            var output="<table><thead><tr><th></th>";
             output+="<th> id комнаты </th>";
             output+="<th> Номер комнаты </th>";
             output+="<th> Тип номера </th>";
             output+="<th> Количество спальных мест </th>";
             output+="<th> Цена за день </th>";
             output+="</tr></thead><tbody>";
            for (var i in json_obj) 
            {
                output+="<tr>";
                output+="<td>" +"<td>" + json_obj[i].roomId +"</td>"+"</td>"+ "<td>"+ json_obj[i].roomNumber + "</td>" 
                        + "<td>"+json_obj[i].bed + "</td>" +"<td>"+ json_obj[i].price + "</td>" 
                        +"<td>"+ json_obj[i].typeRoom +"</td>";
                output+="</tr>"; 
            }
                       
            $('span').html(output);
        },
        dataType: "json"//set to JSON    
    })    
}
