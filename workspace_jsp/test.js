let selector = document.querySelector("select[name='searchFilter']");
	let searchText = document.querySelector("input[name='searchText']");
	selector.addEventListener("change",function(){
		if(this.value == 1 || this.value == 2){
			searchText.setAttribute("type","number")
		}
	})