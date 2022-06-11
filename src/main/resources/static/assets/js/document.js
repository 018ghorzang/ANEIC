
$('document').ready(function(){

    $('table #editButton').on('click', function(event){

        event.preventDefault();
        
        /*** /document/findById/?id=1   ***/
        var href = $(this).attr('href');

        $.get(href,function(document, status){
            $('#id').val(document.id);
            $('#name').val(document.name);
            $('#description').val(document.description);
            $('#size').val(document.size);
        });

    $('#editModal').modal();
    }); 

    /**** Delete the Records ****/

    $('table #deleteButton').on('click', function(event){
        event.preventDefault();

        var href = $(this).attr('href');
        $('#confirmDeleteButton').attr('href', href);

        $('#deleteModal').modal();
    });
    
});









//  var button = document.querySelector('#button');
//  
//  button.addEventListener('click', showAlert);
//  function showAlert(){
//	  alert('function called!');
//  }