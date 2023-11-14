#ifndef P10_FULL_CREDIT_TIME_H_
#define P10_FULL_CREDIT_TIME_H_

#include <iostream>
#include <iomanip>
#include <stdlib.h>

class Time{
    public:
        Time();
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
        friend std::ostream& operator<<(std::ostream& ost, const Time& time);
        friend std::istream& operator>>(std::istream& ist, Time& time);
    private:
        void rationalize();
        int _hour;
        int _minute;
        int _second;
};

#endif