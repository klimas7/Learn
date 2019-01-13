package pl.akamai.puzzle;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
    # Step 1
    $ file puzzle1.tar.gz
    puzzle1.tar.gz: gzip compressed data, last modified: Mon Nov  5 18:43:34 2018, from Unix

    # Step 2
    $ tar -xvvf puzzle1.tar.gz
    -rw-r--r-- ppotrawk/600 11108431 2018-11-05 19:42 Q2hlY2sgTGFzdCBTdHJpbmc=

    # Check 1
    WEB: :) Linked In: Pawel Potrawka

    # Step 3
    $ file Q2hlY2sgTGFzdCBTdHJpbmc\=
    Q2hlY2sgTGFzdCBTdHJpbmc=: gzip compressed data, last modified: Mon Nov  5 18:42:01 2018, from Unix

    # Step 4
    $ tar xvvf Q2hlY2sgTGFzdCBTdHJpbmc=
    -rw-r--r-- ppotrawk/600 23130178 2018-11-05 19:40 rot13.Purpx.0k0-0k7S.Rirel4guPune

    gzip: stdin: decompression OK, trailing garbage ignored
    tar: Child returned status 2
    tar: Error is not recoverable: exiting now

    #Check 2
    Web: rot13

    #Step 4 https://www.rot13.com/
    Purpx.0k0-0k7S.Rirel4guPune -> ROT13 -> Check.0x0-0x7F.Every4thChar

    0x0-0x7F - ASCII

    #Check 3
    $okteta rot13.Purpx.0k0-0k7S.Rirel4guPune &

    Reverse it with speed raw audio.

    #Step 5
    $play -t raw -r 32k -e signed -b 16 -c 4 rot13.Purpx.0k0-0k7S.Rirel4guPune tempo 0.9 reverse

    62656175666F72742E6465636F6465286773712E62796E736F666572646C757375712E7274732F33346D38653768676F696C66703335686534387764763233293A6B65793D666562726577737562737469747574696F6E6369706865722E6465636F646528786C6E79726D766C6D76647267737A6D6C67737669290A
    beaufort.decode(gsq.bynsoferdlusuq.rts/34m8e7hgoilfp35he48wdv23):key=febrewsubstitutioncipher.decode(xlnyrmvlmvdrgszmlgsvi)
                    www.akamaiaffinity.com/34f8y7hgnaczz35ga48afy23                                                                                           COMBINEONEWITHANOTHER

    Try to read this in wireshark ....


 */
public class Notes {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/work/akamai/puzzle/test");
        byte[] bytes = Files.readAllBytes(path);

        for (int i = 1; i < bytes.length; i++) {

            if ((i + 1) % 4 == 0) {
                System.out.printf(String.valueOf((char) bytes[i]));
            }
        }

        //System.out.println("xyz");
    }
}
