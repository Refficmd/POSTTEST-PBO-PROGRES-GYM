package com.mycompany.main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String[]> daftarProgress = new ArrayList<>();
        int pilihan;
        int nextId = 6; // Karena sudah ada 5 data dummy

        // === DATA DUMMY ===
        daftarProgress.add(new String[]{"P1", "1 September 2025", "HIIT", "Burpees 3x12", "Full Body", "30"});
        daftarProgress.add(new String[]{"P2", "2 September 2025", "Strength", "Bench Press 4x10 40kg", "Dada", "45"});
        daftarProgress.add(new String[]{"P3", "3 September 2025", "Cardio", "Treadmill 6km", "Kaki", "35"});
        daftarProgress.add(new String[]{"P4", "4 September 2025", "Yoga", "Sun Salutation x5", "Core", "50"});
        daftarProgress.add(new String[]{"P5", "5 September 2025", "Strength", "Deadlift 5x5 60kg", "Punggung", "40"});

        do {
            System.out.println("\n=== MENU PROGRESS GYM ===");
            System.out.println("1. Tambah Progress");
            System.out.println("2. Lihat Progress");
            System.out.println("3. Update Progress");
            System.out.println("4. Hapus Progress");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Input harus angka, coba lagi: ");
                scanner.next();
            }
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1: // CREATE
                    String id = "P" + nextId++;

                    System.out.print("Tanggal latihan (contoh: 9 September 2025): ");
                    String tanggal = scanner.nextLine().trim();
                    if (tanggal.isEmpty()) {
                        System.out.println("Tanggal tidak boleh kosong.");
                        break;
                    }

                    // Pilih tipe gym
                    String tipe = "";
                    while (true) {
                        System.out.println("Pilih tipe gym:");
                        System.out.println("1. HIIT");
                        System.out.println("2. Yoga");
                        System.out.println("3. Cardio");
                        System.out.println("4. Strength");
                        System.out.print("Masukkan pilihan (1-4): ");

                        if (!scanner.hasNextInt()) {
                            System.out.println("Input harus angka, coba lagi.");
                            scanner.next();
                            continue;
                        }

                        int opsi = scanner.nextInt();
                        scanner.nextLine();

                        switch (opsi) {
                            case 1: tipe = "HIIT"; break;
                            case 2: tipe = "Yoga"; break;
                            case 3: tipe = "Cardio"; break;
                            case 4: tipe = "Strength"; break;
                            default:
                                System.out.println("Input tidak valid, silakan coba lagi.");
                                continue;
                        }
                        break;
                    }

                    System.out.print("Gerakan + Repetisi + Set + Beban (contoh: Push Up 3x15 10kg): ");
                    String gerakan = scanner.nextLine().trim();
                    if (gerakan.isEmpty()) {
                        System.out.println("Gerakan tidak boleh kosong.");
                        break;
                    }

                    System.out.print("Otot yang dilatih (contoh: Dada): ");
                    String otot = scanner.nextLine().trim();
                    if (otot.isEmpty()) {
                        System.out.println("Otot tidak boleh kosong.");
                        break;
                    }

                    System.out.print("Durasi (menit, contoh: 45): ");
                    while (!scanner.hasNextInt()) {
                        System.out.print("Durasi harus angka, coba lagi: ");
                        scanner.next();
                    }
                    int durasi = scanner.nextInt();
                    scanner.nextLine();

                    daftarProgress.add(new String[]{id, tanggal, tipe, gerakan, otot, String.valueOf(durasi)});
                    System.out.println("Progress berhasil ditambahkan dengan ID: " + id);
                    break;

                case 2: // READ
                    if (daftarProgress.isEmpty()) {
                        System.out.println("Belum ada progress tercatat.");
                    } else {
                        String back;
                        do {
                            System.out.println("\n=== DAFTAR PROGRESS ===");
                            for (String[] p : daftarProgress) {
                                System.out.println("ID Progress     : " + p[0]);
                                System.out.println("Tanggal Latihan : " + p[1]);
                                System.out.println("Tipe Gym        : " + p[2]);
                                System.out.println("Gerakan         : " + p[3]);
                                System.out.println("Otot Dilatih    : " + p[4]);
                                System.out.println("Durasi (menit)  : " + p[5]);
                                System.out.println("----------------------------");
                            }
                            System.out.print("Apakah ingin kembali ke menu utama? (y/n): ");
                            back = scanner.nextLine().toLowerCase();
                        } while (!back.equals("y"));
                    }
                    break;

                case 3: // UPDATE
                    if (daftarProgress.isEmpty()) {
                        System.out.println("Tidak ada data untuk diupdate.");
                        break;
                    }

                    System.out.print("Masukkan ID Progress yang ingin diupdate: ");
                    String idUpdate = scanner.nextLine().trim();

                    boolean ditemukanUpdate = false;
                    for (int i = 0; i < daftarProgress.size(); i++) {
                        if (daftarProgress.get(i)[0].equalsIgnoreCase(idUpdate)) {
                            System.out.print("Tanggal baru (contoh: 10 September 2025): ");
                            String tglBaru = scanner.nextLine().trim();
                            System.out.print("Gerakan baru (contoh: Squat 4x12): ");
                            String gerakanBaru = scanner.nextLine().trim();
                            System.out.print("Otot baru (contoh: Kaki): ");
                            String ototBaru = scanner.nextLine().trim();
                            System.out.print("Durasi baru (menit), contoh: 60: ");
                            while (!scanner.hasNextInt()) {
                                System.out.print("Durasi harus angka, coba lagi: ");
                                scanner.next();
                            }
                            int durasiBaru = scanner.nextInt();
                            scanner.nextLine();

                            // tipe gym update tetap ditanya
                            String tipeBaru = "";
                            while (true) {
                                System.out.println("Pilih tipe gym baru:");
                                System.out.println("1. HIIT");
                                System.out.println("2. Yoga");
                                System.out.println("3. Cardio");
                                System.out.println("4. Strength");
                                System.out.print("Masukkan pilihan (1-4): ");

                                if (!scanner.hasNextInt()) {
                                    System.out.println("Input harus angka, coba lagi.");
                                    scanner.next();
                                    continue;
                                }

                                int opsi = scanner.nextInt();
                                scanner.nextLine();

                                switch (opsi) {
                                    case 1: tipeBaru = "HIIT"; break;
                                    case 2: tipeBaru = "Yoga"; break;
                                    case 3: tipeBaru = "Cardio"; break;
                                    case 4: tipeBaru = "Strength"; break;
                                    default:
                                        System.out.println("Input tidak valid, silakan coba lagi.");
                                        continue;
                                }
                                break;
                            }

                            daftarProgress.set(i, new String[]{idUpdate, tglBaru, tipeBaru, gerakanBaru, ototBaru, String.valueOf(durasiBaru)});
                            System.out.println("Progress dengan ID " + idUpdate + " berhasil diperbarui!");
                            ditemukanUpdate = true;
                            break;
                        }
                    }
                    if (!ditemukanUpdate) {
                        System.out.println("Progress dengan ID tersebut tidak ditemukan.");
                    }
                    break;

                case 4: // DELETE
                    if (daftarProgress.isEmpty()) {
                        System.out.println("Tidak ada data untuk dihapus.");
                        break;
                    }

                    System.out.print("Masukkan ID Progress yang ingin dihapus: ");
                    String idHapus = scanner.nextLine().trim();

                    boolean ditemukanHapus = false;
                    for (int i = 0; i < daftarProgress.size(); i++) {
                        if (daftarProgress.get(i)[0].equalsIgnoreCase(idHapus)) {
                            daftarProgress.remove(i);
                            System.out.println("Progress dengan ID " + idHapus + " berhasil dihapus!");
                            ditemukanHapus = true;
                            break;
                        }
                    }
                    if (!ditemukanHapus) {
                        System.out.println("Progress dengan ID tersebut tidak ditemukan.");
                    }
                    break;

                case 5:
                    System.out.println("Terima kasih, program selesai!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }

        } while (pilihan != 5);

        scanner.close();
    }
}
