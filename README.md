# SpringAssessment  
Our task was to build a full-stack To-do list application using Java and the Spring Boot framework, while also building out the front-end with HTML and CSS within a day.

## What did you like about this project?
The project allowed me to practice building a web application from scratch and to troubleshoot any issues that came up along the way (and there were several). The project also gave me an opportunity to think about the design and requirements on a high level before going ahead to write the code. Additionally, the project got me to code with HTML, CSS and JS which I have not touched in some time.

## What did you struggle with in this project?
I encountered an error when trying to perform GET requests on my database. Upon going through the error messages, I realized that it was because the Id name in my Entity class did not match with the database. 

I was also challenged when trying to add a DELETE request function in taskController.js. When I tried to add event listeners to the "delete" icons in the taskListing.js, the browser seemed to be adding the listeners before the page has even loaded the tasks. Then I realized it was because the browser would continue executing code (asynchronously), while waiting for the promise (displayTasks) to return. Hence, I added the event listeners in the same .then() method, after renderTaskPage() has completed execution.

## What would make your experience with this assessment better?
I think a better understanding of how the Entity class links to the database would have prevented me from getting stuck at the GET requests. Also, it helps to have a good understanding of how to use console.log to debug issues along the way. I enjoyed this project and overall it was a good learning experience.
