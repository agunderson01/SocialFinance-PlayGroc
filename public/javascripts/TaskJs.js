var prevToggle;

function CreateTask() {
    var contents = $("#create-task").val();
    var trimmedContents = $.trim(contents);
    if (trimmedContents == "") {
      alert ("Empty shopping items not allowed");
      $("#create-task").val("");
      return false;
    }
    if (contents == "") {
        alert("Enter a valid shopping item");
        $("#create-task").val("");
        return false;
    }
    if (!contents) {
        return;
    }
    contents = trimmedContents;
    $.ajax({
      type: "GET",
      url: "/findTaskByTitle/" + contents
    }).done(function(title) {
      alert("That item is already on shopping list");
      // Clear input
      $("#create-task").val("");
    });
    $.ajax({
        type: "POST",
        url: "/task",
        data: { title: contents }
    }).done(function(id) {
        var div = $("<div>").addClass("list-group-item");
        var be = $("<a>").attr("href", "#").attr("id", id).attr("onclick", "ToggleEdit(this)").append(contents);
        $(div).append($(be));
        $(div).append(CloseButton);
        $("#task_list").append($(div));
        // Clear input
        $("#create-task").val("");
    });
}

function CloseButton() {
    var button = $("<button>").attr({type:"submit", class:"close", onclick:"DeleteTask(this)"}).attr("aria-label", "Close");
    var span = $("<span>").attr("aria-hidden", "true").append("×");
    return $(button).append(span);
}

function UpdateTask(link) {
    console.log($(link).parent().prev().val());
    var parent = $(link).parent();
    var sibling = $(parent).prev();
    var key = $(sibling).attr("id");
    var contents = $(sibling).val();

    $.ajax({
            type: "PUT",
            url: "/task/" + key,
            data: { title: contents }
        }).done(function(msg) {
            $(prevToggle).text(contents);
            $(prevToggle).popover('hide');
            // Updated contents
        }).fail(function(msg) {
            // Failed to update contents
        });
}

function DeleteTasks() {
    console.log(key);
    $.ajax({
        type: "DELETE",
        url: "/task"
    }).done(function(msg) {
        // All tasks successfully removed
    }).fail(function(msg) {
        // Call failed
    });
}

function DeleteTask(link) {
    var parent = $(link).parent();
    var sibling = $(link).prev();
    var key = $(sibling).attr("id");
    //var contents = $(parent).text();
    console.log(key);
    $.ajax({
        type: "DELETE",
        url: "/task/" + key
    }).done(function(msg) {
        parent.remove();
    }).fail(function(msg) {
    });
}

function ToggleEdit(link) {
    if ($(link).is($(prevToggle))) {
        // Same toggle
        // TODO: Fix issue, this does not toggle popover
        $(prevToggle).popover('hide');
        return;
    }
    else if (prevToggle) {
        // Different toggle
        $(prevToggle).popover('hide');
    } else {
        // New toggle
    }
    //$(prev).popover('hide');
    var id = $(link).attr("id");
    $(link).popover({
        html: true,
        content: function() {
            var div = $("<div>").addClass("input-group");
            var input = $("<input>").attr({type:"text", class:"form-control", placeholder:"Enter task description here...", id:id});
            var span = $("<span>").addClass("input-group-btn");
            var button = $("<button>").attr({type:"button", onclick:"UpdateTask(this)"}).addClass("btn btn-secondary").append("Update!");
            $(span).append(button);
            $(div).append(span);
            $(div).prepend(input);
            return div;
        },
        title: "Update Task"
    });

    $(link).popover('show');
    prevToggle = link;

    id = $(link).attr('id');
    var contents = $(link.attr);
}