const p_register = document.getElementById('p_register')
const registerLink = document.getElementById('register_link')
const form = document.getElementById('loginForm');
const registerForm = document.querySelectorAll('.registerForm'); 
const top_p_sign = document.getElementById('top_p_sign')
const btn_sing_in = document.getElementById('btn_sing_in')
const estrela = document.getElementById('estrela')
const sign_in_link = document.getElementById('sign_in_link')
const inputs_formulario = document.querySelectorAll('.input');
const user_created = document.getElementById('user_created');
const hidderDivRegisterAndSignIn = document.getElementById('hidderDivRegisterAndSignIn')
const btn_register = document.getElementById('btn_register');
const btn_welcome = document.getElementById('btn_welcome')

const bntLinkWelcome = document.getElementById('bntLinkWelcome');
// SIGN IN - Quando a pessoa clicar no "Sing-In" para logar (NÃO É O BOTÃO)
sign_in_link.addEventListener('click', function(){
    for(const form of registerForm) {
        form.style.display = 'none'
    }
    top_p_sign.innerHTML = "SING IN TO FOOD WEB"
    estrela.style.display = 'block'
    btn_register.style.display = 'none'
    btn_sing_in.style.display = 'block'
    p_register.innerHTML = "Don't have Account?"
    registerLink.style.display = 'block'
    sign_in_link.style.display = 'none'
})
// Quando a pessoa clicar no Register NOW
registerLink.addEventListener('click', function(){
    
    for(const form of registerForm) {
        form.style.display = 'block'
    }
    top_p_sign.innerHTML = "Creat Account"
    estrela.style.display = 'none'
    btn_sing_in.style.display = 'none'
    btn_register.style.display = 'block'
    p_register.innerHTML = "Have account?"
    registerLink.style.display = 'none'
    sign_in_link.style.display = 'block'
})

// Quando o usuário digitar algo no tampo com o tel, a função é disparada.
// Faz com que o usuário fica impedido de usar letras.
function validateNumber(input) {
    const value = input.value;
    input.value = value.replace(/\D/g, '');
}


btn_register.addEventListener('click', async function(event) {
    event.preventDefault();
    const user = {
        userName: document.getElementById('userName').value,
        userPhone: document.getElementById('userPhone').value,
        userEmail: document.getElementById('userEmail').value,
        userPassword: document.getElementById('userPassword').value
    };

    try {
        const response = await fetch("http://localhost:8080/api/user/creatUser", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(user)
        });

        if (response.ok) {
            top_p_sign.style.display = 'none'
            form_signIn.style.display = 'none' 
            btn_welcome.style.display = 'block'
            bntLinkWelcome.innerHTML = `WELCOME ${user.userName}`
    
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


}
)


