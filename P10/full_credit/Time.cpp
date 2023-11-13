#include "Time.h"

Time::Time(int hour, int minute, int second) : _hour(hour), _minute(minute), _second(second) {};

void Time::rationalize(){
    if(_second >= 60){
        int minutesToAdd = _second / 60;
        _second = _second % 60;
        _minute += minutesToAdd;
    }

    if(_minute >= 60){
        int hoursToAdd = _minute / 60;
        _minute = _minute % 60;
        _hour += hoursToAdd;
    }

    if(_hour >= 24){
        _hour = 0;
        _minute = 0;
        _second = 0;
    }
}

Time Time::operator+(Time time){
    Time result(0, 0, 0);
    result._hour = this->_hour + time._hour;
    result._minute = this->_minute + time._minute;
    result._second = this->_second + time._second;
    result.rationalize();
    return time;
}

Time Time::operator++(){
    this->_second = this->_second + 1;
    return time;
}
