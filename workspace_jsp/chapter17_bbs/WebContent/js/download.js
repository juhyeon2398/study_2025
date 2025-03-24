console.log("download.js >> load")

let download = document.querySelector("#download");
if(download != null){
    download.addEventListener("click",function(e){
        e.preventDefault(); 
        
        let filename = this.getAttribute("href");
        
        let sendData = `cmd=download&filename=${filename}`;
        location.href = `BBSController?${sendData}`;
        console.log(filename)
    })
}