#include <iostream>
#include <sstream>
#include <fstream>

using namespace std;

class People
{
private:
    string Belepes;
    string Name;
    string Azonosito;
    string Kilepes;
public:
    friend ostream& operator<<(ostream& out, const People &p);
    friend istream& operator>>(istream& in, People &p);

    string getBelepes()
    {
        return Belepes;
    }

    string getKilepes()
    {
        return Kilepes;
    }
    string getName()
    {
        return Name;
    }
};

ostream& operator<<(ostream& out, const People &p)
{
    out << p.Belepes << " " << p.Name << " " << p.Azonosito << " " << p.Kilepes;
    return out;
}

istream& operator>>(istream& in, People &p)
{
    string temp;
    getline(in,temp);
    stringstream ss;
    ss << temp;
    bool l = true;
    ss >> p.Belepes >> p.Name >> p.Azonosito;
    p.Kilepes.clear();
    string tempKilepes;
    while(ss >> tempKilepes)
    {
        p.Kilepes = tempKilepes;
    }
    return in;
}

class Enor
{
private:
    People actP;
    string filename;
    fstream f;
public:
    Enor(string f) : filename(f) {}
    void init()
    {
        f.open(filename.c_str());
    }
    void first()
    {
        next();
    }
    void next()
    {
        f >> actP;
    }
    bool isEnd()
    {
        return f.fail();
    }
    People current()
    {
        return actP;
    }
};



int main()
{
    Enor en("input.txt");
    en.init();
    en.first();
    string prevKilepes;
    string prevName;
    int hiba = 0;
    while(!en.isEnd())
    {
        if (en.current().getName() != prevName)
        {
             prevKilepes.clear();
        }


        //cout << en.current().getKilepes() << endl;
        if (en.current().getKilepes().empty() == false && en.current().getBelepes() > en.current().getKilepes())
        {
            hiba++;
            cout << en.current() << endl;
        }
        else if (en.current().getBelepes() < prevKilepes)
        {
            hiba++;
            cout << en.current() << endl;
        }
        prevName = en.current().getName();
        prevKilepes = en.current().getKilepes();
        en.next();
    }
    cout << "A hibas sorok szama: " << hiba << endl;
    return 0;
}
