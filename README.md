# Final Proyek Struktur Data
<ul>
  <li>Mata Kuliah: Struktur Data</li>
  <li>Dosen Pengampu: <a href="https://github.com/Muhammad-Ikhwan-Fathulloh">Muhammad Ikhwan Fathulloh</a></li>
</ul>

## Kelompok
<ul>
  <li>Kelompok: {kelompok}</li>
  <li>Proyek: {proyek}</li>
  <li>Anggota:</li>
  <ul>
    <li>Ketua: <a href="">Hilman Ardiansyah</a></li>
    <li>Anggota 1: <a href="">Ardelia Lutfiani</a></li>
    <li>Anggota 2: <a href="">Muhammad Naufal Riyandi</a></li>
  </ul>
</ul>

## Judul Proyek
<p>Sistem Konser</p>

## Penjelasan Proyek
<p>1. Package tubesdata: Ini adalah nama package yang berisi semua kelas dalam proyek.

<p>2. Records (Peserta dan Tiket): Records adalah fitur yang diperkenalkan dalam Java 14. Mereka digunakan di sini untuk mendefinisikan entitas Peserta (yang merepresentasikan peserta konser dengan nama, email, dan password) dan Tiket (yang merepresentasikan tiket dengan kategori, harga, dan jumlah tersedia).</p>

<p>3. Class Transaksi: Kelas ini merepresentasikan sebuah transaksi yang dilakukan oleh peserta untuk memesan tiket. Transaksi terdiri dari peserta (Peserta), tiket yang dipesan (Tiket), jumlah tiket yang dipesan, dan total harga dari transaksi tersebut. Kelas ini mengimplementasikan Comparable untuk memungkinkan pembandingan antar transaksi berdasarkan total harga.</p>

<p>4. Class RiwayatTransaksi: Kelas ini merepresentasikan riwayat transaksi yang terjadi. Ini menyimpan daftar transaksi dalam bentuk LinkedList.</p>

<p>5. Class Konser dan Band: Kelas Konser merepresentasikan sebuah konser dengan nama dan tanggal, serta daftar tiket dan daftar band yang akan tampil. Kelas Band merepresentasikan sebuah band dengan nama.</p>

<p>6. Method main: Method main adalah titik masuk utama ke program. Di dalamnya, proses berikut terjadi:</p>

<li>Pengguna diminta untuk masuk dengan email dan password menggunakan method login.</li>
<li>Objek konser (Konser) dibuat dengan nama dan tanggal tertentu, dan beberapa band (Band) ditambahkan ke dalamnya.</li>
<li>Beberapa tiket (Tiket) ditambahkan ke konser dengan kategori, harga, dan jumlah tersedia yang berbeda.</li>
<li>Selanjutnya, pengguna diminta untuk memesan tiket dari konser dengan memilih band, kategori tiket, dan jumlah tiket yang diinginkan.</li>
<li>Setelah memesan, transaksi ditambahkan ke riwayat transaksi dan jumlah tiket yang tersedia diperbarui.</li>
<li>Pengguna diberi pilihan untuk melanjutkan memesan atau tidak.</li>
<li>Setelah pengguna selesai memesan, riwayat transaksi ditampilkan dalam urutan harga total dengan menggunakan PriorityQueue.
<p>7. Method login: Method ini meminta pengguna untuk memasukkan email dan password. Jika email dan password yang dimasukkan sesuai dengan admin (admin@gmail.com dan admin123), pengguna diminta untuk memasukkan nama peserta dan objek Peserta baru dibuat.</li></p></p>

## Komponen Proyek
<p>1. Kelas dan Rekaman (Records):

<li>Peserta: Merepresentasikan seorang peserta konser dengan nama, email, dan password.</li>
<li>Tiket: Merepresentasikan sebuah tiket dengan kategori, harga, dan jumlah tersedia. Memiliki method withJumlahTersedia untuk mengubah jumlah tiket yang tersedia.</li>
<li>Transaksi: Mencatat transaksi yang dilakukan oleh peserta, termasuk peserta yang melakukan transaksi, tiket yang dibeli, jumlah tiket yang dibeli, dan total harga transaksi.</li>
<li>RiwayatTransaksi: Menyimpan riwayat transaksi yang telah dilakukan dalam bentuk daftar transaksi.</li>
<li>Konser: Merepresentasikan sebuah konser dengan nama, tanggal, daftar tiket yang tersedia, dan daftar band yang tampil di konser.</li>
<li>Band: Merepresentasikan sebuah band dengan nama. </li></p>

<p>2. Main Class (Main):</p>
<li>Main class merupakan titik masuk utama ke dalam program. Di dalamnya terdapat method main yang mengatur alur utama program, termasuk interaksi dengan pengguna dan pemrosesan pesanan tiket.</li>
<li>Method login: Digunakan untuk melakukan autentikasi pengguna (admin) dengan meminta email dan password.</li>

<p>3. Input-Output menggunakan Scanner:</p>
<li>Pengguna berinteraksi dengan program menggunakan Scanner untuk memasukkan input dari keyboard dan melihat output dari program di konsol.</li>

<p>4. Struktur Data:</p>
<li>Struktur data seperti ArrayList, LinkedList, dan Stack digunakan untuk menyimpan dan mengelola data, seperti daftar tiket dan daftar band dalam sebuah konser, serta daftar transaksi.</li>

<p>5. Pemrosesan Transaksi:</p>
<li>Program memproses transaksi tiket, memvalidasi input pengguna, dan mengupdate jumlah tiket yang tersedia setelah setiap transaksi.</li>

<p>6. Penyimpanan Riwayat Transaksi:</p>
<li>Program menyimpan riwayat transaksi yang telah dilakukan oleh peserta dan menampilkannya di akhir sesi pemesanan.</li>

<p>7. Urutan Transaksi:</p>
<li>Menggunakan PriorityQueue untuk mengurutkan transaksi berdasarkan total harga, sehingga transaksi dengan total harga tertinggi ditampilkan terlebih dahulu.</li>
</p>

## Pembagian Tim
<p>Lorem ipsum sir dolor amet.</p>

## Demo Proyek
<ul>
  <li>Github: <a href="">Github</a></li>
  <li>Youtube: <a href="">Youtube</a></li>
</ul>
