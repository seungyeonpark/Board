let id = document.querySelector('#id')
let email = document.querySelector('#email')
let pw = document.querySelector('#pw')
let confirm_pw = document.querySelector('#confirm-pw')
let btn = document.querySelector('#btn')

btn.addEventListener('click', () => {
    if(id.value == "") {
        label = id.nextElementSibling
        label.classList.add('warning')
        setTimeout(() => {
            label.classList.remove('warning')
        }, 1500)
    } else if(pw.value == "") {
        label = pw.nextElementSibling
        label.classList.add('warning')
        setTimeout(() => {
            label.classList.remove('warning')
        }, 1500)
    } else if(confirm_pw.value == "") {
        label = confirm_pw.nextElementSibling
        label.classList.add('warning')
        setTimeout(() => {
            label.classList.remove('warning')
        }, 1500)
    }
})