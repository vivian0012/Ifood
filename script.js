
const p_register = document.getElementById('p_register')
const registerLink = document.getElementById('register_link')
const form = document.getElementById('loginForm');
const registerForm = document.querySelectorAll('.registerForm'); 
const top_p_sign = document.getElementById('top_p_sign')
const sing_in = document.getElementById('sing_in')
const estrela = document.getElementById('estrela')
const sign_in_link = document.getElementById('sign_in_link')

registerLink.addEventListener('click', function(){
    for(const form of registerForm) {
        form.style.display = 'block'
    }
    top_p_sign.innerHTML = "Creat Account"
    sing_in.innerHTML = 'Register'
    estrela.style.display = 'none'
    p_register.innerHTML = "Have account?"
    registerLink.style.display = 'none'
    sign_in_link.style.display = 'block'
})
// SIGN IN
sign_in_link.addEventListener('click', function(){
    for(const form of registerForm) {
        form.style.display = 'none'
    }
    top_p_sign.innerHTML = "SING IN TO FOOD WEB"
    sing_in.innerHTML = 'SING IN'
    estrela.style.display = 'block'
    p_register.innerHTML = "Don't have Account?"
    registerLink.style.display = 'block'
    sign_in_link.style.display = 'none'
})

// Quando o usuário digitar algo no tampo com o tel, a função é disparada.
// Faz com que o usuário fica impedido de usar letras.
function validateNumber(input) {
    const value = input.value;
    input.value = value.replace(/\D/g, '');
}
regiserLink.addEventListener('click', async function(event){
    event.preventDefault();
    
    if (form.checkValidity()) {
        // Se o formulário for válido, prossiga com a requisição
        const user = {
            userName: document.getElementById('userName').value,
            userPhone: document.getElementById('userPhone'.value),
            userEmail: document.getElementById('userEmail').value,
            userPassword: document.getElementById('userPassword').value
        };
    }

    try {
        const response = await fetch("http://localhost:8080/api/user/login", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(user)
        });

        if (response.ok) {
            const responseData = await response.json();

                if(responseData == true){
                    sucesso.innerHTML = user.userName + " Bonitão!"
                    sucesso.style.visibility = 'visible';
                } else {
                    console.log("ERROR:" + responseData)
                }
      
        }  else if (response.status === 401) {
            sucesso.style.visibility = 'visible';
            sucesso.innerText = "Usuário não identificado."
        } 
        else {
            form.reportValidity();
            console.log("ERRO: " + response.status);
            alert("Erro: Não foi possível realizar o login. Código de erro: " + response.status);
        }

     } catch (error) {
        console.error("Erro na solicitação:", error);
    }
})


