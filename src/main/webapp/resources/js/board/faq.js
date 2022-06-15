



/* $(".faq-header").on("click",function(e){
    
    console.log(this);
    console.log(this.nextElementSibling);
    let bro = this.nextElementSibling.children[0];
    console.log(bro);
    //bro.classList().add("active");
}) */

const header =document.getElementsByClassName("faq-header");

for(let i of header){
    i.addEventListener("click",function(){
        i.nextElementSibling.classList.toggle("active")
        i.parentElement.classList.toggle("changeHead");
    })    
}