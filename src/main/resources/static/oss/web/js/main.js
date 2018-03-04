
var toolbarOptions = [['bold', 'italic'], [{ 'list': 'ordered'}, { 'list': 'bullet' }], ['code'], ['link', 'image'], [{ 'header': 1 }, { 'header': 2 }]];
var quill = new Quill('#editor', {
modules: {
  toolbar: toolbarOptions
},
theme: 'snow'
});
quill.on('text-change', function(delta, oldDelta, source) {
  if (source == 'api') {
    console.log("An API call triggered this change.");
  } else if (source == 'user') {
    console.log("A user action triggered this change.");
  }
  output();
});
function output(){
  $("#source-html").text(quill.container.firstChild.innerHTML);
}