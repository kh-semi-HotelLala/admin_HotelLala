


const header =document.getElementsByClassName("faq-header");

for(let i of header){
    i.addEventListener("click",function(){
        i.nextElementSibling.classList.toggle("active")
        i.parentElement.classList.toggle("changeHead");
    })    
}