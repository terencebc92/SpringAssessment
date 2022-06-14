
const createHTMLList = (idTasks, title, description, targetDate) =>
`
      <tr>
        <th scope="row">${idTasks}</th>
        <td>${title}</td>
        <td>${description}</td>
        <td>${targetDate}</td>
        <td class="text-center"><i class="bi bi-trash-fill" id=${idTasks}></i></td>
      </tr>
`;


function deleteRow(event){
    console.log(event.target);
    let id = event.target.getAttribute("id");
    taskControl.deleteTask(id);
};


class TaskController
{
    constructor()
    {
        this.taskApi = "http://localhost:8080/task/"
        this.addTaskAPI = "http://localhost:8080/task/add";
        this.allTaskAPI = "http://localhost:8080/task/all";

        this._tasks = [];       //create an array to store the details of tasks
    }

    //method to add the tasks into the array
    addTask(title, description, targetDate)
        {
            let taskController = this;
            const formData = new FormData();
            formData.append('title', title);
            formData.append('description', description);
            formData.append('targetDate', targetDate);

           fetch(this.addTaskAPI, {
                 method: 'POST',
                 body: formData
                 })
                 .then(function(response) {
                     console.log(response.status); // Will show you the status
                     if (response.ok) {
                         alert("Successfully Added Task!")
                     }
                     else {
                        throw Error(response.statusText);
                     }
                 })
                 .catch((error) => {
                     console.error('Error:', error);
                     alert("Error adding Task to TaskList")
                 });
        } // end addTask method

    // This method will fetch data from the db using the REST API endpoint from Spring Boot
    displayTask()
    {
         let taskController = this;
         taskController._tasks= []; // clear its tasks

        //fetch data from database using the REST API endpoint from Spring Boot
        fetch(this.allTaskAPI) //GET is default, so don't need to set method: 'GET'
            .then((resp) => resp.json())
            .then(function(data) {
                console.log("2. receive data")
                console.log(data);

                data.forEach(function (task) { // Create taskObject for each, and push each task to the list
                    const taskObj = {
                        id: task.idTasks,
                        title: task.title,
                        description: task.description,
                        targetDate: task.targetDate,
                   };
                    taskController._tasks.push(taskObj);
              });

              taskController.renderTaskPage();
                let links = document.querySelectorAll("i");
                console.log("adding listener to links")
                links.forEach((link) => {
                    link.addEventListener("click", deleteRow);
                });
            })
            .catch(function(error) {
                console.log(error);
            });
    } // End displayTask()



    // Renders the tasks fetched from the displayTask() method
    renderTaskPage()
    {
        let taskHTMLList = [];

        for (let i=0; i<this._tasks.length; i++)
        {
            const task = this._tasks[i];            //assign the individual item to the variable
            const taskHTML = createHTMLList(task.id, task.title, task.description, task.targetDate);
            taskHTMLList.push(taskHTML);
        }


        const pHTML = taskHTMLList.join('\n');
        document.querySelector('#tbody').innerHTML = pHTML;

    }


    deleteTask(id)
        {
            console.log(this.taskApi + id)
           fetch(this.taskApi + id, {
                 method: 'DELETE',
                 })
                 .then(function(response) {
                     console.log(response.status); // Will show you the status
                     if (response.ok) {
                         alert("Successfully deleted Task!")
                         window.location.reload();
                     }
                     else {
                        throw Error(response.statusText);
                     }
                 })
                 .catch((error) => {
                     console.error('Error:', error);
                     alert("Error deleting Task from TaskList")
                 });
        } // end addTask method


}   //End of TaskController class
