function updateDateTime() {
    const now = new Date();

    const date =now.toLocaleDateString();
    const time = now.getHours() + ":" + now.getMinutes()+":"+now.getSeconds();


    document.getElementById('date').textContent = date;
    document.getElementById('time').textContent = time;
}

setInterval(updateDateTime, 1000);
updateDateTime();