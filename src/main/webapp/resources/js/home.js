$(function () {
    var $container = $('.container');
    var $row = $('.row');
    var $add = $('#addButton');
    var $remove = $('#removeButton');
    var $focused;
    var $counter = $("#counter").val();
    var $submit_btn = $("#submit");
    
    $container.on('click', 'input', function () {
        $focused = $(this);
    });

 // Increments the delay on each item.
    $('.rolldown-list li').each(function () {
      var delay = ($(this).index() / 4) + 's';
      $(this).css({
        webkitAnimationDelay: delay,
        mozAnimationDelay: delay,
        animationDelay: delay
      });
    });
    
    $submit_btn.on('click', function (){
        UserAction();
    });
    
    $add.on('click', function () {
        var $newRow = $row.clone().insertAfter('.row:last');
        $newRow.find('input').each(function () {
            this.value = '';
        });
        document.getElementById("counter").value = ++$counter;        
    });

    $remove.on('click', function () {
        if (!$focused) {
            alert('Select a row to delete (click en input with it)');
            return;
        }

        var $currentRow = $focused.closest('.row');
        if ($currentRow.index() === 0) {
            // don't remove first row
            alert("You can't remove first row");
        } else {
            $currentRow.remove();
            $focused = null;
        }
        document.getElementById("counter").value = --$counter;        
    })

    function UserAction() {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                $("#myList").children().remove();
                arr = JSON.parse(this.responseText);
                $.each(arr, function(index, value){
                    var text = value;
                    $('<li />', {html: text}).appendTo('ul.rolldown-list')
                 })
            }
        };
        xhttp.open("POST", "http://localhost:8080/algos/api/sort", true);
        xhttp.setRequestHeader("Content-type", "application/json");
        var setting = {
                         "list" : getValues()
                      }
        var json = JSON.stringify(setting);
        xhttp.send(json);
    }
    
    function getValues(){
      return $("input[name='size[]']").map(function() {
            return parseInt(this.value);
        }).get();
    }

});