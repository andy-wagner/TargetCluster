package test;

import target.Target;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * 대한민국의 시도 및 시군구 정보를 타겟 인스턴스의 카테고리로 가져오기 위한 클래스
 */
public class ConstKoreaLocation {

    public static List<City> cities;

    public static class GeoCode{
        private int cid;
        private String name;
        private String abbr;

        public GeoCode(int cid, String name, String abbr) {
            this.cid = cid;
            this.name = name;
            this.abbr = abbr;
        }

        public int getCid() {
            return cid;
        }

        public void setCid(int cid) {
            this.cid = cid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAbbr() {
            return abbr;
        }

        public void setAbbr(String abbr) {
            this.abbr = abbr;
        }
    }

    public static class City{
        private int id;
        private String name;
        private String abbr;
        private List<GeoCode> list;

        public City(int id, String name, String abbr) {
            this.id = id;
            this.name = name;
            this.abbr = abbr;
            this.list = new Vector<>();
        }

        public List<GeoCode> getList() {
            return list;
        }

        public void setList(List<GeoCode> list) {
            this.list = list;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAbbr() {
            return abbr;
        }

        public void setAbbr(String abbr) {
            this.abbr = abbr;
        }
    }



    public static void init(){
        cities = new Vector<>();
        List<GeoCode> geoCodes = new Vector<>();
        Map<Integer, City> cityMap = new HashMap<>();

        cities.add(new City(1,"서울특별시","서울"));
        cities.add(new City(2,"경기도","경기"));
        cities.add(new City(3,"부산광역시","부산"));
        cities.add(new City(6,"인천광역시","인천"));
        cities.add(new City(7,"대전광역시","대전"));
        cities.add(new City(8,"충청북도","충북"));
        cities.add(new City(9,"충청남도","충남"));
        cities.add(new City(10,"강원도","강원"));
        cities.add(new City(11,"경상북도","경북"));
        cities.add(new City(12,"경상남도","경남"));
        cities.add(new City(13,"제주도","제주"));
        cities.add(new City(14,"울산광역시","울산"));
        cities.add(new City(15,"광주광역시","광주"));
        cities.add(new City(16,"전라북도","전북"));
        cities.add(new City(17,"전라남도","전남"));
        cities.add(new City(18,"대구광역시","대구"));
        cities.add(new City(19,"세종시","세종시"));

        for(City city : cities){
            cityMap.put(city.getId(), city);
        }

        geoCodes.add(new GeoCode(1,"강남구","강남"));
        geoCodes.add(new GeoCode(1,"강동구","강동"));
        geoCodes.add(new GeoCode(1,"강북구","강북"));
        geoCodes.add(new GeoCode(2,"가평군","가평"));
        geoCodes.add(new GeoCode(1,"강서구","강서"));
        geoCodes.add(new GeoCode(6,"남구","남구"));
        geoCodes.add(new GeoCode(1,"관악구","관악"));
        geoCodes.add(new GeoCode(1,"광진구","광진"));
        geoCodes.add(new GeoCode(1,"구로구","구로"));
        geoCodes.add(new GeoCode(1,"금천구","금천"));
        geoCodes.add(new GeoCode(1,"노원구","노원"));
        geoCodes.add(new GeoCode(1,"도봉구","도봉"));
        geoCodes.add(new GeoCode(1,"동대문구","동대문"));
        geoCodes.add(new GeoCode(1,"동작구","동작"));
        geoCodes.add(new GeoCode(1,"마포구","마포"));
        geoCodes.add(new GeoCode(1,"서대문구","서대문"));
        geoCodes.add(new GeoCode(1,"서초구","서초"));
        geoCodes.add(new GeoCode(1,"성동구","성동"));
        geoCodes.add(new GeoCode(1,"성북구","성북"));
        geoCodes.add(new GeoCode(1,"송파구","송파"));
        geoCodes.add(new GeoCode(1,"양천구","양천"));
        geoCodes.add(new GeoCode(1,"영등포구","영등포"));
        geoCodes.add(new GeoCode(1,"용산구","용산"));
        geoCodes.add(new GeoCode(1,"은평구","은평"));
        geoCodes.add(new GeoCode(1,"종로구","종로"));
        geoCodes.add(new GeoCode(1,"중구","중구"));
        geoCodes.add(new GeoCode(1,"중랑구","중랑"));
        geoCodes.add(new GeoCode(2,"고양시","고양"));
        geoCodes.add(new GeoCode(2,"부천시","부천"));
        geoCodes.add(new GeoCode(2,"성남시","성남"));
        geoCodes.add(new GeoCode(2,"수원시","수원"));
        geoCodes.add(new GeoCode(2,"안산시","안산"));
        geoCodes.add(new GeoCode(2,"용인시","용인"));
        geoCodes.add(new GeoCode(2,"안양시","안양"));
        geoCodes.add(new GeoCode(2,"의왕시","의왕"));
        geoCodes.add(new GeoCode(2,"의정부시","의정부"));
        geoCodes.add(new GeoCode(2,"이천시","이천"));
        geoCodes.add(new GeoCode(2,"파주시","파주"));
        geoCodes.add(new GeoCode(2,"평택시","평택"));
        geoCodes.add(new GeoCode(2,"포천시","포천"));
        geoCodes.add(new GeoCode(2,"하남시","하남"));
        geoCodes.add(new GeoCode(2,"화성시","화성"));
        geoCodes.add(new GeoCode(2,"과천시","과천"));
        geoCodes.add(new GeoCode(2,"광명시","광명"));
        geoCodes.add(new GeoCode(2,"광주시","광주"));
        geoCodes.add(new GeoCode(2,"구리시","구리"));
        geoCodes.add(new GeoCode(2,"군포시","군포"));
        geoCodes.add(new GeoCode(2,"김포시","김포"));
        geoCodes.add(new GeoCode(2,"남양주시","남양주"));
        geoCodes.add(new GeoCode(2,"동두천시","동두천"));
        geoCodes.add(new GeoCode(2,"시흥시","시흥"));
        geoCodes.add(new GeoCode(2,"안성시","안성"));
        geoCodes.add(new GeoCode(2,"용인시","용인"));
        geoCodes.add(new GeoCode(2,"오산시","오산"));
        geoCodes.add(new GeoCode(2,"여주시","여주"));
        geoCodes.add(new GeoCode(2,"양주시","양주"));
        geoCodes.add(new GeoCode(2,"양평군","양평"));
        geoCodes.add(new GeoCode(2,"연천군","연천"));
        geoCodes.add(new GeoCode(6,"계양구","계양"));
        geoCodes.add(new GeoCode(6,"남동구","남동"));
        geoCodes.add(new GeoCode(6,"동구","동구"));
        geoCodes.add(new GeoCode(6,"부평구","부평"));
        geoCodes.add(new GeoCode(6,"서구","서구"));
        geoCodes.add(new GeoCode(6,"연수구","연수"));
        geoCodes.add(new GeoCode(6,"중구","중구"));
        geoCodes.add(new GeoCode(6,"옹진군","옹진"));
        geoCodes.add(new GeoCode(6,"강화군","강화"));
        geoCodes.add(new GeoCode(7,"대덕구","대덕"));
        geoCodes.add(new GeoCode(7,"동구","동구"));
        geoCodes.add(new GeoCode(7,"서구","서구"));
        geoCodes.add(new GeoCode(7,"유성구","유성"));
        geoCodes.add(new GeoCode(7,"중구","중구"));
        geoCodes.add(new GeoCode(8,"제천시","제천"));
        geoCodes.add(new GeoCode(8,"청주시","청주"));
        geoCodes.add(new GeoCode(8,"충주시","충주"));
        geoCodes.add(new GeoCode(8,"괴산군","괴산"));
        geoCodes.add(new GeoCode(8,"음성군","음성"));
        geoCodes.add(new GeoCode(8,"단양군","단양"));
        geoCodes.add(new GeoCode(8,"옥천군","옥천"));
        geoCodes.add(new GeoCode(8,"영동군","영동"));
        geoCodes.add(new GeoCode(8,"증평군","증평"));
        geoCodes.add(new GeoCode(8,"진천군","진천"));
        geoCodes.add(new GeoCode(8,"보은군","보은"));
        geoCodes.add(new GeoCode(8,"청원군","청원"));
        geoCodes.add(new GeoCode(9,"천안시","천안"));
        geoCodes.add(new GeoCode(9,"공주시","공주"));
        geoCodes.add(new GeoCode(9,"논산시","논산"));
        geoCodes.add(new GeoCode(9,"계룡시","계룡"));
        geoCodes.add(new GeoCode(9,"보령시","보령"));
        geoCodes.add(new GeoCode(9,"아산시","아산"));
        geoCodes.add(new GeoCode(9,"서산시","서산"));
        geoCodes.add(new GeoCode(9,"당진시","당진"));
        geoCodes.add(new GeoCode(9,"청양군","청양"));
        geoCodes.add(new GeoCode(9,"홍성군","홍성"));
        geoCodes.add(new GeoCode(9,"예산군","예산"));
        geoCodes.add(new GeoCode(9,"태안군","태안"));
        geoCodes.add(new GeoCode(9,"금산군","금산"));
        geoCodes.add(new GeoCode(9,"부여군","부여"));
        geoCodes.add(new GeoCode(9,"서천군","서천"));
        geoCodes.add(new GeoCode(9,"청주시","청주"));
        geoCodes.add(new GeoCode(10,"원주시","원주"));
        geoCodes.add(new GeoCode(10,"강릉시","강릉"));
        geoCodes.add(new GeoCode(10,"태백시","태백"));
        geoCodes.add(new GeoCode(10,"속초시","속초"));
        geoCodes.add(new GeoCode(10,"삼척시","삼척"));
        geoCodes.add(new GeoCode(10,"춘천시","춘천"));
        geoCodes.add(new GeoCode(10,"동해시","동해"));
        geoCodes.add(new GeoCode(10,"횡성군","횡성"));
        geoCodes.add(new GeoCode(10,"영월군","영월"));
        geoCodes.add(new GeoCode(10,"평창군","평창"));
        geoCodes.add(new GeoCode(10,"정선군","정선"));
        geoCodes.add(new GeoCode(10,"화천군","화천"));
        geoCodes.add(new GeoCode(10,"철원군","철원"));
        geoCodes.add(new GeoCode(10,"양구군","양구"));
        geoCodes.add(new GeoCode(10,"인제군","인제"));
        geoCodes.add(new GeoCode(10,"고성군","고성"));
        geoCodes.add(new GeoCode(10,"홍천군","홍천"));
        geoCodes.add(new GeoCode(10,"양양군","양양"));
        geoCodes.add(new GeoCode(11,"안동시","안동"));
        geoCodes.add(new GeoCode(11,"구미시","구미"));
        geoCodes.add(new GeoCode(11,"포항시","포항"));
        geoCodes.add(new GeoCode(11,"영천시","영천"));
        geoCodes.add(new GeoCode(11,"영주시","영주"));
        geoCodes.add(new GeoCode(11,"경주시","경주"));
        geoCodes.add(new GeoCode(11,"김천시","김천"));
        geoCodes.add(new GeoCode(11,"경산시","경산"));
        geoCodes.add(new GeoCode(11,"상주시","상주"));
        geoCodes.add(new GeoCode(11,"문경시","문경"));
        geoCodes.add(new GeoCode(11,"청도군","청도"));
        geoCodes.add(new GeoCode(11,"고령군","고령"));
        geoCodes.add(new GeoCode(11,"성주군","성주"));
        geoCodes.add(new GeoCode(11,"칠곡군","칠곡"));
        geoCodes.add(new GeoCode(11,"군위군","군위"));
        geoCodes.add(new GeoCode(11,"예천군","예천"));
        geoCodes.add(new GeoCode(11,"의성군","의성"));
        geoCodes.add(new GeoCode(11,"봉화군","봉화"));
        geoCodes.add(new GeoCode(11,"울진군","울진"));
        geoCodes.add(new GeoCode(11,"울릉군","울릉"));
        geoCodes.add(new GeoCode(11,"영덕군","영덕"));
        geoCodes.add(new GeoCode(11,"청송군","청송"));
        geoCodes.add(new GeoCode(11,"영양군","영양"));
        geoCodes.add(new GeoCode(11,"영주시","영주"));
        geoCodes.add(new GeoCode(12,"진주시","진주"));
        geoCodes.add(new GeoCode(12,"통영시","통영"));
        geoCodes.add(new GeoCode(12,"사천시","사천"));
        geoCodes.add(new GeoCode(12,"김해시","김해"));
        geoCodes.add(new GeoCode(12,"밀양시","밀양"));
        geoCodes.add(new GeoCode(12,"거제시","거제"));
        geoCodes.add(new GeoCode(12,"창원시","창원"));
        geoCodes.add(new GeoCode(12,"양산시","양산"));
        geoCodes.add(new GeoCode(12,"함안군","함안"));
        geoCodes.add(new GeoCode(12,"창녕군","창녕"));
        geoCodes.add(new GeoCode(12,"고성군","고성"));
        geoCodes.add(new GeoCode(12,"산청군","산청"));
        geoCodes.add(new GeoCode(12,"남해군","남해"));
        geoCodes.add(new GeoCode(12,"하동군","하동"));
        geoCodes.add(new GeoCode(12,"의령군","의령"));
        geoCodes.add(new GeoCode(12,"합천군","합천"));
        geoCodes.add(new GeoCode(12,"함양군","함양"));
        geoCodes.add(new GeoCode(12,"거창군","거창"));
        geoCodes.add(new GeoCode(12,"마산시","마산"));
        geoCodes.add(new GeoCode(13,"제주시","제주"));
        geoCodes.add(new GeoCode(13,"서귀포시","서귀포"));
        geoCodes.add(new GeoCode(14,"남구","남구"));
        geoCodes.add(new GeoCode(14,"동구","동구"));
        geoCodes.add(new GeoCode(14,"북구","북구"));
        geoCodes.add(new GeoCode(14,"중구","중구"));
        geoCodes.add(new GeoCode(3,"강서구","강서"));
        geoCodes.add(new GeoCode(3,"금정구","금정"));
        geoCodes.add(new GeoCode(3,"남구","남구"));
        geoCodes.add(new GeoCode(3,"남동구","남동구"));
        geoCodes.add(new GeoCode(3,"동구","동구"));
        geoCodes.add(new GeoCode(3,"동래구","동래"));
        geoCodes.add(new GeoCode(3,"부산진구","진구"));
        geoCodes.add(new GeoCode(3,"북구","북구"));
        geoCodes.add(new GeoCode(3,"사상구","사상구"));
        geoCodes.add(new GeoCode(3,"사하구","사하"));
        geoCodes.add(new GeoCode(3,"서구","서구"));
        geoCodes.add(new GeoCode(3,"서구","서구"));
        geoCodes.add(new GeoCode(3,"수영구","수영"));
        geoCodes.add(new GeoCode(3,"연제구","연제"));
        geoCodes.add(new GeoCode(3,"영도구","영도"));
        geoCodes.add(new GeoCode(3,"중구","중구"));
        geoCodes.add(new GeoCode(3,"해운대구","해운대"));
        geoCodes.add(new GeoCode(3,"기장군","기장"));
        geoCodes.add(new GeoCode(15,"광산구","광산"));
        geoCodes.add(new GeoCode(15,"남구","남구"));
        geoCodes.add(new GeoCode(15,"동구","동구"));
        geoCodes.add(new GeoCode(15,"북구","북구"));
        geoCodes.add(new GeoCode(15,"서구","서구"));
        geoCodes.add(new GeoCode(16,"정읍시","정읍"));
        geoCodes.add(new GeoCode(16,"남원시","남원"));
        geoCodes.add(new GeoCode(16,"김제시","김제"));
        geoCodes.add(new GeoCode(16,"전주시","전주"));
        geoCodes.add(new GeoCode(16,"익산시","익산"));
        geoCodes.add(new GeoCode(16,"군산시","군산"));
        geoCodes.add(new GeoCode(16,"순창군","순창"));
        geoCodes.add(new GeoCode(16,"고창군","고창"));
        geoCodes.add(new GeoCode(16,"완주군","완주"));
        geoCodes.add(new GeoCode(16,"부안군","부안"));
        geoCodes.add(new GeoCode(16,"진안군","진안"));
        geoCodes.add(new GeoCode(16,"장수군","장수"));
        geoCodes.add(new GeoCode(16,"임실군","임실"));
        geoCodes.add(new GeoCode(16,"무주군","무주"));
        geoCodes.add(new GeoCode(17,"목포시","목포"));
        geoCodes.add(new GeoCode(17,"여수시","여수"));
        geoCodes.add(new GeoCode(17,"광양시","광양"));
        geoCodes.add(new GeoCode(17,"순천시","순천"));
        geoCodes.add(new GeoCode(17,"나주시","나주"));
        geoCodes.add(new GeoCode(17,"장성군","장성"));
        geoCodes.add(new GeoCode(17,"장흥군","장흥"));
        geoCodes.add(new GeoCode(17,"완도군","완도"));
        geoCodes.add(new GeoCode(17,"강진군","강진"));
        geoCodes.add(new GeoCode(17,"담양군","담양"));
        geoCodes.add(new GeoCode(17,"진도군","진도"));
        geoCodes.add(new GeoCode(17,"곡성군","곡성"));
        geoCodes.add(new GeoCode(17,"해남군","해남"));
        geoCodes.add(new GeoCode(17,"신안군","신안"));
        geoCodes.add(new GeoCode(17,"영암군","영암"));
        geoCodes.add(new GeoCode(17,"구례군","구례"));
        geoCodes.add(new GeoCode(17,"고흥군","고흥"));
        geoCodes.add(new GeoCode(17,"무안군","무안"));
        geoCodes.add(new GeoCode(17,"보성군","보성"));
        geoCodes.add(new GeoCode(17,"함평군","함평"));
        geoCodes.add(new GeoCode(17,"화순군","화순"));
        geoCodes.add(new GeoCode(17,"영광군","영광"));
        geoCodes.add(new GeoCode(18,"남구","남구"));
        geoCodes.add(new GeoCode(18,"달서구","달서"));
        geoCodes.add(new GeoCode(18,"동구","동구"));
        geoCodes.add(new GeoCode(18,"북구","북구"));
        geoCodes.add(new GeoCode(18,"서구","서구"));
        geoCodes.add(new GeoCode(18,"수성구","수성"));
        geoCodes.add(new GeoCode(18,"중구","중구"));
        geoCodes.add(new GeoCode(18,"달성군","달성"));

        for(GeoCode geoCode : geoCodes){
            City city = cityMap.get(geoCode.getCid());
            city.getList().add(geoCode);
        }

    }

    public static Target.TargetBuilder getBuilderForLocationTarget(){
        init();

        Target.TargetBuilder targetBuilder = Target.builder().debug();

        for(City city : cities){
            targetBuilder.addCategory(city.getAbbr());
            targetBuilder.addSynonym(city.getAbbr(), city.getName());
            for(GeoCode geoCode : city.getList()){
                targetBuilder.addDetail(city.getAbbr(), geoCode.getAbbr());
//                targetBuilder.addSynonym(geoCode.getAbbr(), geoCode.getName());
            }
        }

        return targetBuilder;
    }

}
