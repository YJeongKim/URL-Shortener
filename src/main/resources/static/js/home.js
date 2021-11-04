const home = {
    init : function () {
        let _this = this;
        $('#result-div').hide()
        $('#button-shorten').on('click', function () {
            _this.shorten();
        });
        $('#button-copy').on('click', function () {
            _this.copy();
        });
    },
    shorten : function () {
        let data = {
            url: $("#url").val()
        }
        $.ajax({
            type: "post",
            url: "/api/urls",
            data: JSON.stringify(data),
            contentType: 'application/json; charset=utf-8',
        }).done(function (data) {
            $('#result-div').show()
            let shortenedUrl = data["shortenedUrl"]
            $('#result').val(shortenedUrl)
        }).fail(function (error) {
            alert(error["responseJSON"]["message"]);
            $('#url').val("")
            $('#result').val("")
        });
    },
    copy : function () {
        navigator.clipboard.writeText($('#result').val()).then(r => alert("copied!"));
    }
}

home.init()