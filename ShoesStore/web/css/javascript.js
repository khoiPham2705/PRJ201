/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
let timer;

document.addEventListener('input', e => {
    const el = e.target;

    if (el.matches('.search input[data-color]')) {
        clearTimeout(timer);
        timer = setTimeout(() => {
            document.documentElement.style.setProperty(`--color-${el.dataset.color}`, el.value);
        }, 100);
    }
});


