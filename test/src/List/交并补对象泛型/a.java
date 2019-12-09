//package List.交并补对象泛型;
//
//import java.util.ArrayList;
//
///**
// * @description:
// * @author: Mr.Z
// * @create: 2019-04-06 16:30
// */
//public class a {
//    public static void main(String[] args) {
//
//  /*      //新表有 就添加(左独有)  新表没有 就删除（右独有）  新旧表都有 修改（交集）
//        //交集  新旧表都有
//        departmentNewListJiao.retainAll(departmentOldList);
//        System.out.println("交集=" + departmentNewListJiao);  //DepartmentInDto(departmentCode=0200, departmentName=全科医疗科), DepartmentInDto(departmentCode=0300, departmentName=内科)]
//
//        //取左（新）独有
//        departmentNewListZuo.removeAll(departmentOldList);
//        System.out.println("取左（新）独有=" + departmentNewListZuo);  //[DepartmentInDto(departmentCode=0400, departmentName=骨科)]
//
//        //取右（旧）独有
//        departmentOldList.removeAll(departmentNewListYou);
//        System.out.println("取右（旧）独有=" + departmentOldList);  //[DepartmentInDto(departmentCode=0100, departmentName=预防保健科)]
//
//        //并集
//        departmentNewListBing.removeAll(departmentOldList);
//        departmentNewListBing.addAll(departmentOldList);
//        System.out.println("并集=" + departmentNewListBing);  //[DepartmentInDto(departmentCode=0400, departmentName=骨科), DepartmentInDto(departmentCode=0100, departmentName=预防保健科), DepartmentInDto(departmentCode=0200, departmentName=全科医疗科), DepartmentInDto(departmentCode=0300, departmentName=内科)]
//*/
//
//
//      HospitalDepartmentInDto hospitalDepartmentInDtoJiao = new HospitalDepartmentInDto();
//        HospitalDepartmentInDto hospitalDepartmentInDtoZuo = new HospitalDepartmentInDto();
//        HospitalDepartmentInDto hospitalDepartmentInDtoYou = new HospitalDepartmentInDto();
//        HospitalDepartmentInDto hospitalDepartmentInDtoBing = new HospitalDepartmentInDto();
//
//        hospitalDepartmentInDtoJiao.setDepartmentList(departmentListNew);
//        hospitalDepartmentInDtoZuo.setDepartmentList(departmentListNew);
//        hospitalDepartmentInDtoYou.setDepartmentList(departmentListNew);
//        hospitalDepartmentInDtoBing.setDepartmentList(departmentListNew);
//
//        //获得传过来的tCode和Name
//        List<DepartmentInDto> departmentNewListJiao = hospitalDepartmentInDtoJiao.getDepartmentList();
//        List<DepartmentInDto> departmentNewListZuo = hospitalDepartmentInDtoZuo.getDepartmentList();
//        List<DepartmentInDto> departmentNewListYou = hospitalDepartmentInDtoYou.getDepartmentList();
//        List<DepartmentInDto> departmentNewListBing = hospitalDepartmentInDtoBing.getDepartmentList();
//    }
//}
