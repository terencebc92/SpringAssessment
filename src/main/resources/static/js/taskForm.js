const taskControl = new TaskController();


//When user clicks on 'Save Item', calls API to add items to the database
//Add an 'onsubmit' event listener for taskform to add a task
newTaskForm.addEventListener('submit', (event) => {
    // Prevent default action
    event.preventDefault();
    // Select the inputs
    const newTaskTitleInput = document.querySelector('#newTaskTitleInput');
    const newTaskDescriptionInput = document.querySelector('#newTaskDescriptionInput');
    const newTaskDateInput = document.querySelector('#newTaskDateInput');


    /*
        Do the Validation code here
    */

    // Get the values of the inputs - variable names to be same as MySQL columns
    const title = newTaskTitleInput.value;
    const description = newTaskDescriptionInput.value;
    const targetDate = newTaskDateInput.value;


    // Clear the form
    newTaskTitleInput.value = '';
    newTaskDescriptionInput.value = '';
    newTaskDateInput.value = '';

    // Add the task to the task manager
    taskControl.addTask(title, description, targetDate);

}); // end of addEventListener
