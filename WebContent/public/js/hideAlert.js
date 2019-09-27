/**
 * 
 */
let stateCheck = setInterval(() => {
		  if (document.readyState === 'complete') {
		    clearInterval(stateCheck);
		    // document ready
		    var el = document.getElementById("alerta");
		    el.style.display = (el.style.display == 'none') ? 'block' : 'none';
		    
		  }
          }, 2500);