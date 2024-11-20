const mapSelect = document.getElementById('map-select');
const form = document.getElementById('formsave');
const drawingInput = document.getElementById('json');

form.addEventListener('submit', (event) => {
    event.preventDefault();

    const drawingJSON = JSON.stringify(drawingInput);

    drawingInput.value = drawingJSON;

    console.log("Sending JSON:", drawingJSON);
    form.submit();
});
