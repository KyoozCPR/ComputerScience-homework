let line = 0;
function updateDateTime() {
    const now = new Date();

    const date =now.toLocaleDateString();
    const time = now.getHours() + ":" + now.getMinutes()+":"+now.getSeconds();

    line += 6;
    document.getElementById('date').textContent = date;
    document.getElementById('time').textContent = time;
    document.getElementById('line').style =
        'rotate:' +line+'deg';
}

setInterval(updateDateTime, 1000);
updateDateTime();