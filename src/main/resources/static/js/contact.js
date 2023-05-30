document.getElementById("submitBtn").addEventListener("click", function(event) {
    event.preventDefault();
    setWhatsAppLink();
});


function getFormattedDate() {
    var today = new Date();
    var day = today.getDate();
    var month = today.getMonth() + 1; // Ditambah 1 karena indeks bulan dimulai dari 0
    var year = today.getFullYear();

    // Menambahkan nol di depan jika tanggal atau bulan kurang dari 10
    if (day < 10) {
        day = '0' + day;
    }
    if (month < 10) {
        month = '0' + month;
    }

    return day + '/' + month + '/' + year;
}

// Fungsi untuk mengatur URL dan format pesan WhatsApp
function setWhatsAppLink() {
    var date = getFormattedDate();
    var name = document.getElementById("name").value;
    var phone = document.getElementById("phone").value;
    var email = document.getElementById("email").value;
    var subject = document.getElementById("subject").value;
    var message = document.getElementById("message").value;

    var formattedMessage = encodeURIComponent(`===== TIKET PERTANYAAN/KONTAK =====\nTanggal: ${date}\nNama Pengirim: ${name}\nNomor Telepon: ${phone}\nEmail Pengirim: ${email}\n=================================\nSubjek: ${subject}\nPesan:\n${message}`);

    var whatsappLink = `https://api.whatsapp.com/send?phone=6287873504007&text=${formattedMessage}`;

    window.location.href = whatsappLink;
}