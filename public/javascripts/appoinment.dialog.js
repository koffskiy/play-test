$(document).ready(function () {
    var dialog = $("#appointmentModel").dialog({
        width: 860,
        height: 600,
        modal: true,
        autoOpen: false,
        buttons: {
            "Ok": function () {
                createAppointment();
                dialog.dialog("close");
            },
            Cancel: function () {
                dialog.dialog("close");
            }
        },
        close: function () {
            dialog.find("form")[0].reset();
        }

    });
    $('.timepicker').datetimepicker({
        datepicker: false,
        format: 'H:i',
        step: 30
    });
    $('.datetimepicker').datetimepicker();
    $('#appointmentDuration').on('change', function () {
        var duration = this.value * 60;
        $('.timepicker').datetimepicker({
            datepicker: false,
            format: 'H:i',
            step: duration
        });
    })

    $("#create").button().on("click", function () {
        dialog.dialog("open");
    });

    function createAppointment() {
        $("#appointmentForm").ajaxSubmit({url: '/appointment', type: 'post'}, function() {
            location.reload();
        })
    }
});

