function calculateDifference() {
    const price1 = parseInt(document.getElementById('price1').value) || 0;
    const price2 = parseInt(document.getElementById('price2').value) || 0;
    const difference = price2 - price1;
    document.getElementById("price3").value = difference;
}