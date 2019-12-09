public class DaysBetween2Dates {

    static class DateObj {
        int month;
        int day;
        int year;
        public DateObj(String dt) {
            String[] dtStr = dt.split("-");
            month  = Integer.parseInt( dtStr[0] );
            day    = Integer.parseInt( dtStr[1] );
            year   = Integer.parseInt( dtStr[2] );
        }
    }

    public static int daysBetween(DateObj d1, DateObj d2) {
        boolean isLeapYr = false;
        if ((d2.year % 4) == 0) {
           isLeapYr = true;
        }
        int countDays = 0;
        int monthDays = 0;
        for (int m = d1.month; m <= d2.month; m++) {
            switch (m) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                    monthDays = 31;
                    break;
                case 2:
                    monthDays = isLeapYr ? 29 : 28;
                    break;
                case 4:
                case 6:
                case 8:
                case 10:
                case 12:
                    monthDays = 30;
                    break;
            }
            if (m == d1.month && m == d2.month) {
                countDays += (d2.day - d1.day);
            }
            else if (m == d1.month) {
                countDays += (monthDays - d1.day);
            }
            else if (m == d2.month) {
                countDays += d2.day;
            }
            else {
                countDays += monthDays;
            }
        }
        return countDays;
    }

    public static int dayCountBetweenDays(String dt1, String dt2) {
        DateObj dtObj1 = new DateObj(dt1);
        DateObj dtObj2 = new DateObj(dt2);
        int deltaDays = 0;
        if (dtObj2.year > dtObj1.year) {
            int diffYear = dtObj2.year - dtObj1.year;
            int numLeapYears = diffYear/4;
            int leapDays = (numLeapYears*1);
            if (dtObj1.year%4 == 0) {
                if (dtObj1.month <= 2 && dtObj1.day < 29)
                    leapDays += 1;
            }
            if (dtObj2.year%4 == 0) {
                if (dtObj2.month > 2)
                    leapDays += 1;
                else
                    leapDays += (diffYear%4==0) ? -1: 0;
            }

            if (dtObj2.month < dtObj1.month) {
                diffYear -= 1;
            }
            else if (dtObj1.month == dtObj2.month) {
                if (dtObj2.day < dtObj1.day)
                    diffYear -= 1;
            }
            deltaDays += (365 * diffYear) + leapDays;
            if (dtObj2.month > dtObj1.month) {
                deltaDays += daysBetween(dtObj1, dtObj2);
            }
            else if (dtObj2.month == dtObj1.month) {
                if (dtObj2.day > dtObj1.day) {
                    deltaDays += (dtObj2.day - dtObj1.day);
                }
            }
        }
        else {
            deltaDays += daysBetween(dtObj1, dtObj2);
        }
        return deltaDays;
    }

    public static void main(String[] args) {
        String dt1 = "02-10-2014";
        String dt2 = "03-10-2015";
        System.out.println("Days Count: " + dayCountBetweenDays(dt1, dt2));

        String dt3 = "02-10-2000";
        String dt4 = "03-10-2000";
        System.out.println("Days Count: " + dayCountBetweenDays(dt3, dt4));

        String dt5 = "02-10-2000";
        String dt6 = "02-10-2000";
        System.out.println("Days Count: " + dayCountBetweenDays(dt5, dt6));

        String dt7 = "02-01-2000";
        String dt8 = "02-01-2004";
        System.out.println("Days Count: " + dayCountBetweenDays(dt7, dt8));
    }
}
