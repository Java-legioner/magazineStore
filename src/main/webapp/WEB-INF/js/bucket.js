
$(document).ready(function(){
    $("#search").on("keyup", function() {
        var term = $(this).val().toLowerCase();
        $("table tbody tr").each(function(){
            $row = $(this);
            var name = $row.find("td:nth-child(2)").text().toLowerCase();
            console.log(name);
            if(name.search(term) < 0){
                $row.hide();
            } else{
                $row.show();
            }
        });
    });
});

let buckets = null;
$.get("buckets", function (data) {
        if(data !== ''){
            buckets = data;
        }
}).done(function () {
    let tableContent = " <thead>" +
        "                <tr>" +
        "                    <th style='width: 22%;'>Name</th>" +
        "                    <th style='width: 22%;'>Description</th>" +
        "                    <th>Price</th>" +
        "                    <th>PurchaseDate</th>" +
        "                    <th>Options</th>" +
        "                </tr>" +
        "                </thead>"

        jQuery.each(buckets, function (i, value) {
            tableContent += "     <tbody>" +
                "                <tr>" +
                "                    <td>" + value.name +"</td>" +
                "                    <td>"+ value.description +"</td>" +
                "                    <td>"+ value.price +"</td>" +
                "                    <td>"+ value.purchaseDate+"</td>" +
                "                    <td>" +
                "                        <a href='#' class='delete' onclick='deleteOrderFromBucket(" + value.bucketId + ")' title='Delete' data-toggle='tooltip'>" +
                "<i class='material-icons'>&#xE872;</i>" +
                "</a>" +
                "                    </td>\n" +
                "                </tr>"
        });

    $('.table').html(tableContent);
    
});

function deleteOrderFromBucket(bucketId) {
    let customUrl = '';
    let urlContent = window.location.href.split('/');
    for (let i = 0; i < urlContent.length-1; i++) {
        customUrl += urlContent[i] + '/';
    }

    customUrl += 'bucket?bucketId=' + bucketId;

    $.ajax({
        url:customUrl,
        type: 'DELETE',
        success: function (data) {
            if(data == 'Success'){
                location.reload();
            }

        }
    });


}