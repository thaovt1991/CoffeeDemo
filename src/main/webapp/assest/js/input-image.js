function openFile(event) {
    let input = event.target;

    let reader = new FileReader();
    reader.onload = function () {
        let dataURL = reader.result;
        let output = document.getElementById('output');
        output.src = dataURL;
        document.getElementById("base64").value = dataURL;
    }
    reader.readAsDataURL(input.files[0]);
};