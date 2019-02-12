$(document).ready({});

    $("#table_button").click(function getTables(){
        if($.fn.dataTable.isDataTable('#table_Tablex')){
        $("#table_Tablex").DataTable().destroy();
        }

        $.ajax({
            url: "/reservation/getTables",
            type: "GET",
            success: function(data){
                $('#table_Tablex').DataTable({
                    data: data,
                    columns:
                        [
                        {data: 'id'},
                        {data: 'numberOfSeats'},
                        {data: 'type'}
                        ]
                })
            }
        })
    })

    $("#ReservationsButton").click(function getReservations(){
            if($.fn.dataTable.isDataTable('#table_Reservations')){
            $("#table_Reservations").DataTable().destroy();
            }

            $.ajax({
                url: "/reservation/getReservations",
                type: "GET",
                success: function(data){
                    console.log(data);
                    $('#table_Reservations').DataTable({
                        data: data,
                        columns:
                            [
                            {data: 'guestId.name'},
                            {data: 'beginDateTime',
                                render: function(data, type, row){
                                                if(type === "sort" || type === "type"){
                                                    return data;
                                                }
                                                return moment(data).format("HH:mm DD-MM-YYYY");
                                            }
                            },
                            {data: 'tableId.0.id'},
                            {data: 'nrOfPeople'},
                            {data: 'nrOfChildren'}
                            ]
                    })
                }
            })
        })


    $("#round_table").click(function createRoundTable(){
        $.ajax({
            url: "/reservation/createRoundTable",
            type: "GET",
            success: console.log("round table created")
        })
    })

    $("#square_table").click(function createSquareTable(){
            $.ajax({
                url: "/reservation/createSquareTable",
                type: "GET",
                success: console.log("square table created")
            })
        })

    $("#button").click(function checkAvailable() {
                               console.log("send proposal")
                                       var product = {
                                           date  : $('#inputDate').val(),
                                           beginTime  : $('#inputTime').val(),
                                           numberOfAdults : $('#inputAdults').val(),
                                           numberOfChildren : $('#inputChildren').val()
                                       };

                                       var json = JSON.stringify(product);

                                        $.ajax({
                                               type: "POST",
                                               url: "/reservation/checkAvailable",
                                               data: json,
                                               contentType: "application/json",
                                               success: function (data) {
                                               if (data){
                                               alert("A reservation for this number of people at selected date and time is available! Please fill out your personal information and click Confirm reservation to finalize your reservation");
                                               }
                                               else if (data == false){
                                               alert("Unfortunately the selected combination of party size, time and date is not available. Please select a different time and/or date");
                                               }
                                               else{
                                               alert("Something went wrong, please try again.");
                                               }
                                               }
                                         });
                               }
    )

    $("#ConfirmButton").click(function confirmReservation() {
                               console.log("send confirmation")
                                       var proposal = {
                                           date  : $('#inputDate').val(),
                                           beginTime  : $('#inputTime').val(),
                                           numberOfAdults : $('#inputAdults').val(),
                                           numberOfChildren : $('#inputChildren').val()
                                       };

                                       var personal = {
                                           name : ($('#inputLastName').val() + ', ' + $('#inputFirstName').val()),
                                           telephoneNumber: $('#inputPhone').val(),
                                           email: $('#inputEmail').val()
                                           }

                                     //  var jsonPersonal = JSON.stringify(personal);
                                     //  var jsonProposal = JSON.stringify(proposal);

                                       var jsonTotal = JSON.stringify({guest : personal, reservationProposal : proposal})


                                        $.ajax({
                                               type: "POST",
                                               url: "/reservation/createReservation",
                                               data: jsonTotal,
                                               contentType: "application/json",
                                               success: function (data) {
                                               console.log(data);
                                               alert('Your Reservation has been received');
                                               }
                                         });
                               }
    )
//    $('#table_id').DataTable();
//    updateAllProducts();





