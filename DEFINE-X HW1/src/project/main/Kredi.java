package project.main;

import java.math.BigDecimal;
import java.time.LocalDate;

import project.modelsKredi.*;

public class Kredi {
        // main method
        public static void main(String[] args) {
                ObjectManager objectManager = ObjectManager.getInstance();
                Ziraatbank ziraatbank = objectManager.createInstanceZiraatbank();
                Halkbank Halkbank = objectManager.createInstanceHalkbank();
                Akbank Akbank = objectManager.createInstanceAkbank();
                LoanFactory loanFactory = objectManager.createLoanFactory();
                UserRepository userRepository = objectManager.createUserRepository();
                BankRepository bankRepository = BankRepository.getInstance();

                 

                // create 10 random user
                User user = objectManager.createUser("Ali", "Veli", "aliveli@gmail.com", "1234567890", "5309434390", "Ankara",LocalDate.of(1990, 11, 26),true);
                User sameEmailUser = objectManager.createUser("dogu","kurt","aliveli@gmail.com","1234567890","5309434390","Ankara",LocalDate.of(1998,9,14),true); 
                User user2 = objectManager.createUser("Cem", "drman", "cemdrman@gmail.com", "9876543210", "5321234567", "İstanbul",LocalDate.of(1987,6,2), false);
                User user3 = objectManager.createUser("Ayşe", "Kaya", "aysekaya@gmail.com", "4561237890", "5359876543", "İzmir",LocalDate.of(1970,6,5),true);
                User user4 = objectManager.createUser("Mehmet", "Öztürk", "mehmetozturk@gmail.com", "6547893210", "5315678901", "Bursa",LocalDate.of(1976,3,11), false);
                User user5 = objectManager.createUser("Fatma", "Demir", "fatmademir@gmail.com", "3216549870", "5382345678", "Antalya",LocalDate.of(1992,7,8), true);
                User user6 = objectManager.createUser("Mustafa", "Şahin", "mustafasahin@gmail.com", "7894561230", "5364567890", "Adana",LocalDate.of(1991,8,4), false);
                User user7 = objectManager.createUser("Zeynep", "Aydın", "zeynepaydin@gmail.com", "1597532468", "5377894561", "Mersin",LocalDate.of(1986,9,2), true);
                User user8 = objectManager.createUser("Emre", "Kurt", "emrekurt@gmail.com", "8523697410", "5349876543", "İzmir",LocalDate.of(1999,10,18),true);
                User user9 = objectManager.createUser("Gizem", "Yıldız", "gizemyildiz@gmail.com", "3698521470", "5396543210", "Bolu",LocalDate.of(1983,11,25), true);


                CreditCard card = objectManager.createCreditCard("card",ziraatbank, new BigDecimal(100));
                CreditCard card2 = objectManager.createCreditCard("card2",ziraatbank, new BigDecimal(200));
                CreditCard card3 = objectManager.createCreditCard("card3",Halkbank, new BigDecimal(300));
                CreditCard card4 = objectManager.createCreditCard("card4",Halkbank, new BigDecimal(400));
                CreditCard card5 = objectManager.createCreditCard("card5",Akbank, new BigDecimal(500));
                CreditCard card6 = objectManager.createCreditCard("card6",Akbank, new BigDecimal(600));

                Loan consumerLoan = loanFactory.createLoan("consumer", new BigDecimal(1000), 12, ziraatbank,0.01);
                Loan consumerLoan2 = loanFactory.createLoan("consumer", new BigDecimal(2000), 24, ziraatbank,0.02);
                Loan consumerLoan3 = loanFactory.createLoan("consumer", new BigDecimal(3000), 36, Halkbank,0.03);
                Loan consumerLoan4 = loanFactory.createLoan("consumer", new BigDecimal(4000), 48, Halkbank,0.04);
                Loan consumerLoan5 = loanFactory.createLoan("consumer", new BigDecimal(5000), 60, Akbank,0.05);
                Loan consumerLoan6 = loanFactory.createLoan("consumer", new BigDecimal(6000), 72, Akbank,0.06);


                Loan mortgageLoan = loanFactory.createLoan("mortgage", new BigDecimal(1000000), 12, ziraatbank,0.1,"Ankara");
                Loan mortgageLoan2 = loanFactory.createLoan("mortgage", new BigDecimal(2000000), 24, ziraatbank,0.15,"İstanbul");
                Loan mortgageLoan3 = loanFactory.createLoan("mortgage", new BigDecimal(3000000), 36, Halkbank,0.2,"İzmir");
                Loan mortgageLoan4 = loanFactory.createLoan("mortgage", new BigDecimal(4000000), 48, Halkbank,0.25,"Bursa");
                Loan mortgageLoan5 = loanFactory.createLoan("mortgage", new BigDecimal(5000000), 60, Akbank,0.3,"Antalya");
                Loan mortgageLoan6 = loanFactory.createLoan("mortgage", new BigDecimal(6000000), 72, Akbank,0.35,"Adana");
                

                Loan vehicleLoan = loanFactory.createLoan("vehicle", new BigDecimal(10000), 12, ziraatbank,0.1,"car","BMW","2015","100000");
                Loan vehicleLoan2 = loanFactory.createLoan("vehicle", new BigDecimal(20000), 24, ziraatbank,0.15,"motorcycle","Yamaha","2018","20000");
                Loan vehicleLoan3 = loanFactory.createLoan("vehicle", new BigDecimal(30000), 36, Halkbank,0.2,"car","Mercedes","2019","300000");
                Loan vehicleLoan4 = loanFactory.createLoan("vehicle", new BigDecimal(40000), 48, Halkbank,0.25,"motorcycle","Honda","2020","40000");
                Loan vehicleLoan5 = loanFactory.createLoan("vehicle", new BigDecimal(50000), 60, Akbank,0.3,"car","Audi","2021","500000");
                Loan vehicleLoan6 = loanFactory.createLoan("vehicle", new BigDecimal(60000), 72, Akbank,0.35,"motorcycle","Kawasaki","2022","60000");
                
                Application application = objectManager.createLoanApplication(vehicleLoan4,new BigDecimal("256666"),user,LocalDate.now());
                Application application2 = objectManager.createLoanApplication(mortgageLoan2,new BigDecimal("176876"),user2,LocalDate.now());
                Application application3 = objectManager.createLoanApplication(consumerLoan3,new BigDecimal("111111"),user3,LocalDate.of(2024, 02, 24));
                Application application4 = objectManager.createLoanApplication(consumerLoan4,new BigDecimal("222222"),user4,LocalDate.of(2023, 03, 14));
                Application application5 = objectManager.createLoanApplication(mortgageLoan5,new BigDecimal("333333"),user5,LocalDate.of(2022, 04, 26));
                Application application6 = objectManager.createLoanApplication(mortgageLoan4,new BigDecimal("444444"),user6,LocalDate.of(2021, 05, 27));
                Application application7 = objectManager.createLoanApplication(vehicleLoan,new BigDecimal("555555"),user7,LocalDate.of(2024, 06, 28));
                Application application8 = objectManager.createLoanApplication(consumerLoan2,new BigDecimal("666666"),user8,LocalDate.of(2019, 07, 29));
                Application application9 = objectManager.createLoanApplication(vehicleLoan3,new BigDecimal("777777"),user9,LocalDate.of(2018, 8, 30));
                Application application10 = objectManager.createLoanApplication(consumerLoan5,new BigDecimal("888888"),user,LocalDate.of(2017, 9, 23));
                Application application11 = objectManager.createLoanApplication(mortgageLoan6,new BigDecimal("999999999"),user2,LocalDate.of(2016, 10, 1));
                Application application12 = objectManager.createLoanApplication(vehicleLoan2,new BigDecimal("1111111111111"),user3,LocalDate.of(2015, 11, 2));
                Application application13 = objectManager.createLoanApplication(consumerLoan6,new BigDecimal("121212"),user4,LocalDate.of(2014, 12, 3));
                Application application14 = objectManager.createLoanApplication(mortgageLoan3,new BigDecimal("131313"),user5,LocalDate.of(2024, 1, 4));
                Application application15 = objectManager.createLoanApplication(vehicleLoan5,new BigDecimal("141414"),user6,LocalDate.of(2012, 2, 5));
                Application application16 = objectManager.createLoanApplication(consumerLoan,new BigDecimal("151515"),user7,LocalDate.of(2024, 3, 6));
                Application application17 = objectManager.createLoanApplication(mortgageLoan,new BigDecimal("161616"),user8,LocalDate.of(2024, 4, 7));
                Application application18 = objectManager.createLoanApplication(vehicleLoan6,new BigDecimal("171717"),user9,LocalDate.of(2024, 5, 8));

                Application application19 = objectManager.createCreditCardApplication(card, user, LocalDate.now());
                Application application20 = objectManager.createCreditCardApplication(card2, user2, LocalDate.now());
                Application application21 = objectManager.createCreditCardApplication(card3, user3, LocalDate.of(2024, 02, 14));
                Application application22 = objectManager.createCreditCardApplication(card4, user4, LocalDate.of(2023, 02, 10));
                Application application23 = objectManager.createCreditCardApplication(card5, user2, LocalDate.of(2024, 04, 26));
                Application application24 = objectManager.createCreditCardApplication(card6, user6, LocalDate.of(2021, 05, 27));
                Application application25 = objectManager.createCreditCardApplication(card, user2, LocalDate.of(2024, 06, 28));
                Application application26 = objectManager.createCreditCardApplication(card, user5, LocalDate.of(2024, 06, 28));

                Campaign campaign = objectManager.createCampaign("Kampanya", card, "Öğrenci Kartı", LocalDate.of(2024, 02, 15), LocalDate.of(2024, 02, 20), LocalDate.of(2024, 2, 25));
                Campaign campaign1 = objectManager.createCampaign("Kampanya1", card, "Vergi İadesi", LocalDate.of(2024, 02, 16), LocalDate.of(2024, 02, 21), LocalDate.of(2024, 2, 26));
                Campaign campaign2 = objectManager.createCampaign("Kampanya2", card, "Yaz Tatili İndirimi", LocalDate.of(2024, 03, 01), LocalDate.of(2024, 03, 10), LocalDate.of(2024, 3, 15));
                Campaign campaign3 = objectManager.createCampaign("Kampanya3", card2, "Eğitim Desteği", LocalDate.of(2024, 03, 05), LocalDate.of(2024, 03, 15), LocalDate.of(2024, 3, 20));
                Campaign campaign4 = objectManager.createCampaign("Kampanya4", card2, "İşe Yeni Başlayanlara Özel", LocalDate.of(2024, 03, 10), LocalDate.of(2024, 3, 20), LocalDate.of(2024, 3, 25));
                Campaign campaign5 = objectManager.createCampaign("Kampanya5", card3, "Aile Paketi", LocalDate.of(2024, 03, 15), LocalDate.of(2024, 03, 25), LocalDate.of(2024, 3, 30));
                Campaign campaign6 = objectManager.createCampaign("Kampanya6", card3, "Yeni Kart Bonusu", LocalDate.of(2024, 02, 17), LocalDate.of(2024, 02, 22), LocalDate.of(2024, 02, 27));
                Campaign campaign7 = objectManager.createCampaign("Kampanya7", card4, "Hediye Çeki", LocalDate.of(2024, 02, 18), LocalDate.of(2024, 02, 23), LocalDate.of(2024, 2, 28));
                Campaign campaign8 = objectManager.createCampaign("Kampanya8", card5, "Doğum Günü İndirimi", LocalDate.of(2024, 02, 19), LocalDate.of(2024, 02, 24), LocalDate.of(2024, 2, 29));
                Campaign campaign11 = objectManager.createCampaign("Kampanya9", card5, "Kış İndirimleri", LocalDate.of(2024, 03, 01), LocalDate.of(2024, 03, 10), LocalDate.of(2024, 3, 15));
                Campaign campaign12 = objectManager.createCampaign("Kampanya10", card5, "Anneler Günü Özel", LocalDate.of(2024, 03, 05), LocalDate.of(2024, 03, 15), LocalDate.of(2024, 03, 20));
                Campaign campaign13 = objectManager.createCampaign("Kampanya11", card6, "Sevgililer Günü Hediyesi", LocalDate.of(2024, 03, 10), LocalDate.of(2024, 03, 20), LocalDate.of(2024, 03, 25));
                Campaign campaign14 = objectManager.createCampaign("Kampanya12", card6, "Bayram İndirimleri", LocalDate.of(2024, 03, 15), LocalDate.of(2024, 03, 25), LocalDate.of(2024, 03, 30));
                Campaign campaign15 = objectManager.createCampaign("Kampanya13", card6, "Yılbaşı Çekilişi", LocalDate.of(2024, 03, 20), LocalDate.of(2024, 03, 30), LocalDate.of(2024, 4, 4));
                Campaign campaign16 = objectManager.createCampaign("Kampanya14", card6, "Okul Başlangıcı İndirimi", LocalDate.of(2024, 03, 25), LocalDate.of(2024, 04, 04), LocalDate.of(2024, 4, 9));
                Campaign campaign17 = objectManager.createCampaign("Kampanya15", card6, "Kredi Kartı Harcamalarında İade", LocalDate.of(2024, 03, 30), LocalDate.of(2024, 04, 9), LocalDate.of(2024, 4, 14));


                
                System.out.println("----------------");
                System.out.println("The user with the most applications is: "+userRepository.getMaxApplicationUser()+" and the user has "+userRepository.getMaxApplicationUser().getApplicationList().size()+" applications.");
                System.out.println("----------------");
                System.out.println("The application with the highest loan amount is: "+userRepository.getMaxApplication()+" and the loan amount is "+userRepository.getMaxApplication().getLoanAmount()+".");
                System.out.println("----------------");
                System.out.println("The applications in this month are: ");
                userRepository.getApplicationsInThisMonth().forEach(System.out::println);
                System.out.println("---------------");
                System.out.println("Credit card with campings in descending order: ");
                for(CreditCard creditCard : bankRepository.getCreditCardCampaignDescendingOrder())
                        System.out.println(creditCard+" and its campaign size is:"+creditCard.getCampaignSize());
                System.out.println("----------------");
                System.out.println("The applications with the email cemdrman@gmail.com are: ");
                userRepository.getUserByEmail("cemdrman@gmail.com").getApplicationList().forEach(System.out::println);
                System.out.println("----------------");
                
               
            
                
                



                

        


                
                

               
        }
}
