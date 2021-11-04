const home = {
    shorten : function () {
        let data = {
            url: $("#url").val()
        }
        $.ajax({
            type: "post",
            url: "/api/urls",
            data: JSON.stringify(data),
            contentType: 'application/json; charset=utf-8',
            success: function (res) {
                let shortenedUrl = res["shortenedUrl"]
                $('#shortened-url').val(shortenedUrl)
            },
            error: function (error) {
                alert(error["responseJSON"]["message"]);
                $('#url').val("")
                $('#shortened-url').val("")
            }
        });
    },
    copy : function () {
        navigator.clipboard.writeText($('#shortened-url').val()).then(r => alert("copied!"));
    },
    clear : function () {
        $('#url').val("")
        $('#shortened-url').val("")
    }
}