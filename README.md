# Error_Correcting_Encoder_Decoder

### This is a console program which imitates a process of sending a message through a poor internet connection, during which errors on the bit level occur. At the end of the process, errors are corrected and original message is restored and saved in the target file.
### Program works in three modes (encode, send, decode) and in order to appropriately present aforementioned process, user needs to put original message into the send.txt file and then he should run the program in sequence: encode -> send -> decode. Modes works as follow:
#### encode - program reads in original message from send.txt file, encodes the message using Hamming code [7,4] and saves encoded message in the encoded.txt file. If source file (send.txt) does not exist, program terminates.
#### send - program reads in encoded message from encoded.txt file, introduces error in one bit per each byte and saves that message into the received.txt file.
#### decode - program reads in message from received.txt file, finds and corrects errors in each byte, decodes message and saves that message into the decoded.txt file.
#### Both files: send.txt and decoded.txt should contain the same message which should be a readable text.
#### Files: encoded.txt and received.txt due to encoding process and introduced errors, probably will not be readable as plain text therefore it is recommended to use "BinEd - Binary/Hexadecimal Editor" for checking their content.