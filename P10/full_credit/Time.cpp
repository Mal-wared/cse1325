#include "Time.h"

Time::Time(){
    _hour = 0;
    _minute = 0;
    _second = 0;
};

Time::Time(int hour, int minute, int second) 
: _hour(hour), _minute(minute), _second(second) {};

void Time::rationalize(){
    if(_second > 59){
        int minutesToAdd = _second / 60;
        _second = _second % 60;
        _minute += minutesToAdd;
    }

    if(_second < 0){
        int absSecond = std::abs(_second);
        if(absSecond > 59){
            int minutesToRemove = absSecond / 60;
            _second = 60 - (absSecond % 60);
            _minute -= minutesToRemove;
        }
        else{
            _minute--;
            _second = 60 - absSecond;
        }
    }

    if(_minute > 59){
        int hoursToAdd = _minute / 60;
        _minute = _minute % 60;
        _hour += hoursToAdd;
    }

    if(_minute < 0){
        int absMinute = std::abs(_minute);
        if(absMinute > 59){
            int hoursToRemove = absMinute / 60;
            _minute = 60 - (absMinute % 60);
            _hour -= hoursToRemove;
        }
        else{
            _hour--;
            _minute = 60 - absMinute;
        }
    }

    if(_hour >= 24 || _hour < 0){
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
    return result;
}

Time& Time::operator++(){
    ++this->_second;
    this->rationalize();
    return *this;
}

Time Time::operator++(int){
    Time previousTime = *this;
    ++this->_second;
    this->rationalize();
    return previousTime;
}

bool Time::operator==(Time time){
    if(time._hour == this->_hour && time._minute == this->_minute && time._second == this->_second){
        return true;
    }
    return false;
}

bool Time::operator!=(Time time){
    if(time._hour == this->_hour && time._minute == this->_minute && time._second == this->_second){
        return false;
    }
    return true;
}

bool Time::operator<(Time time){
    if(this->_hour < time._hour){
        return true;
    }
    else if(this->_hour == time._hour && this->_minute < time._minute){
        return true;
    }
    else if(this->_hour == time._hour && this->_minute == time._minute && this->_second < time._second){
        return true;
    }
    return false;
}

bool Time::operator>(Time time){
    if(this->_hour > time._hour){
        return true;
    }
    else if(this->_hour == time._hour && this->_minute > time._minute){
        return true;
    }
    else if(this->_hour == time._hour && this->_minute == time._minute && this->_second > time._second){
        return true;
    }
    return false;
}

bool Time::operator<=(Time time){
    if(this->operator<(time) || this->operator==(time)){
        return true;
    }
    return false;
}

bool Time::operator>=(Time time){
    if(this->operator>(time) || this->operator==(time)){
        return true;
    }
    return false;
}

std::ostream& operator<<(std::ostream& ost, const Time& time){
    Time rationalizedTime = time;  // Create a copy to avoid modifying the original object
    rationalizedTime.rationalize();  // Rationalize the copy

    ost << std::setfill('0') << std::setw(2) << rationalizedTime._hour << ":"
        << std::setw(2) << rationalizedTime._minute << ":" << std::setw(2) << rationalizedTime._second;
    return ost;
}

std::istream& operator>>(std::istream& ist, Time& time){
    char colon1, colon2;
    int hour, minute, second;

    if(ist >> std::setw(2) >> hour >> colon1 >> std::setw(2) >> minute >> colon2 >> std::setw(2) >> second && colon1 == ':' && colon2 == ':') {
        time._hour = hour;
        time._minute = minute;
        time._second = second;
        time.rationalize();
    } 
    else{
        // Set the stream state to std::ios::fail if the format is invalid
        ist.setstate(std::ios::failbit);
    }

    return ist;
}