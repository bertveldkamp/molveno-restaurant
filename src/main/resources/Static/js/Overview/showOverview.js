$(document).ready(
    function showOverview()
    {
        $.ajax
        ({
            type:"GET",
            url:"/overview",
            success:function(data)
            {
                console.log(data)
                var html = "<table class ='table table-borderless'><tr><td>Name</td><td>price</td><td>amount</td></tr>"
                var total = 0;
                $.each(data, function(index,value)
                {
                    console.log(index);
                    console.log(value);
                    html = html + "<tr><td>" + value.name  + "</td><td>" + value.price + "</td><td>" + value.amount + "</td></tr>";
                    total += (value.price * value.amount)
                })

                html = html + "</table>";

                html = html + "<div class = 'container text-right'> <p> Total price: " + total + "</p> </div>";
                $('#overview').html(html);
            }
        })
    }
)