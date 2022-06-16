AVR instruction summary and assembler

Aplikasi ini mengambil informasi dari AVR Instruction Set Manual (Link http://ww1.microchip.com/downloads/en/devicedoc/atmel-0856-avr-instruction-set-manual.pdf) lalu mengekstrak informasi-informasi penting seperti description, syntax, dan opcode masing-masing instruksi dengan Java Pattern (RegEx) lalu menyimpannya dengan mengaplikasikan prinsip OOP. Dengan menggunakan informasi syntax dan opcode yang didapat, aplikasi ini juga dapat mengkorversi dari instruksi assembly AVR ke bentuk opcode yang sesuai.

Video demo:

<a href="http://www.youtube.com/watch?feature=player_embedded&v=xYgjwC5yei0" target="_blank"><img src="http://img.youtube.com/vi/xYgjwC5yei0/0.jpg" 
alt="IMAGE ALT TEXT HERE" width="240" height="180" border="10" /></a>

Catatan: program mencetak null jika instruksi yang akan dikonversi tidak sesuai dengan semua syntax yang ada.
