#ifndef P10_FULL_CREDIT_TIME_H_
#define P10_FULL_CREDIT_TIME_H_

#include <iostream>

class Time{
    public:
        Time(int hour, int minute, int second);
        Time operator+(Time time);
        Time& operator++();
        Time operator++(int);
        bool operator==(Time time);
        bool operator!=(Time time);
        bool operator<(Time time);
        bool operator>(Time time);
        bool operator<=(Time time);
        bool operator>=(Time time);
        friend std::ostream& operator<<(const std::ostream& ost, Time& time);
        friend std::istream& operator>>(const std::istream& ist, Time& time);
    private:
        void rationalize();
        int compare(Time time);
        int _hour;
        int _minute;
        int _second;
};

#endif