$(document).ready(function() {

    $('#dataTable').DataTable( {
        "columns": [
            { "data": "name" }
        ]/*,
        "ajax": {
            "url": "./appointments",
            "type": "GET",
            "success": function(json, status, fnCallback) {
                *//* Do whatever additional processing you want on the callback,
                *//* then tell DataTables *//*
                json = JSON.stringify(json);
                json = '{"data" : '+json+'}';
                console.log(json);
                fnCallback(json);
            }
        }*/
    } );
} );