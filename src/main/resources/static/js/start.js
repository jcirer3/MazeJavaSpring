roomDataJson = JSON.parse(roomData); // pareseetjam
console.log("Room Data:", roomDataJson);

if (roomData) {
    drawRoom(roomDataJson);
} else {
    console.warn("No hay datos de la habitación.");
}

function drawRoom(room) {
    console.log(room);
    console.log(typeof(room.north))
    const canvas = document.getElementById('roomCanvas');
    const ctx = canvas.getContext('2d');

    const width = canvas.width;
    const height = canvas.height;

    const wallThickness = 50;

    const doorWidth = 50;
    const doorHeight = 50;

    // Clear
    ctx.clearRect(0, 0, width, height);

    // color negro
    ctx.fillStyle = 'black';

    // pinta la porta nort wall
    if (room.north === -1) {
        ctx.fillRect(0, 0, width, wallThickness);
    } else {
        const doorStart = (width / 2) - (doorWidth / 2);
        const doorEnd = doorStart + doorWidth;
        ctx.fillRect(0, 0, doorStart, wallThickness); // Left segment
        ctx.fillRect(doorEnd, 0, width - doorEnd, wallThickness); // Right segment
    }

    if (room.south === -1) {
        ctx.fillRect(0, height - wallThickness, width, wallThickness);
    } else {
        const doorStart = (width / 2) - (doorWidth / 2);
        const doorEnd = doorStart + doorWidth;
        ctx.fillRect(0, height - wallThickness, doorStart, wallThickness); // Left segment
        ctx.fillRect(doorEnd, height - wallThickness, width - doorEnd, wallThickness); // Right segment
    }

    if (room.east === -1) {
        ctx.fillRect(width - wallThickness, 0, wallThickness, height);
    } else {
        const doorStart = (height / 2) - (doorHeight / 2);
        const doorEnd = doorStart + doorHeight;
        ctx.fillRect(width - wallThickness, 0, wallThickness, doorStart); // Top segment
        ctx.fillRect(width - wallThickness, doorEnd, wallThickness, height - doorEnd); // Bottom segment
    }

    if (room.west === -1) {
        ctx.fillRect(0, 0, wallThickness, height);
    } else {
        const doorStart = (height / 2) - (doorHeight / 2);
        const doorEnd = doorStart + doorHeight;
        ctx.fillRect(0, 0, wallThickness, doorStart); // Top segment
        ctx.fillRect(0, doorEnd, wallThickness, height - doorEnd); // Bottom segment
    }
}

function handleDirectionClick(direction) {
    // Update the URL to include the direction as a query parameter
    window.location.href = `/nav?dir=${direction}`;
}