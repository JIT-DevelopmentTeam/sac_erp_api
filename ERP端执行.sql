---�ƶ����ݿ⽨��TB_DataSynchLog
---ԭ��:ͨ����ѯERP��-��������ͬ����־TB_DataSynchLog ʱ���������������ϱ��ʱ������бȽ�
If Exists(Select 1 From Sysobjects WHere Name='TB_DataSynchLog' And xType='U')
Drop table TB_DataSynchLog
GO
Create Table TB_DataSynchLog
(
FClassID Int Not Null,UNIQUE (FClassID),
FDataType Varchar(200),
FTableName Varchar(100),
FDescription Varchar(255),
FModifyTime binary(12),
Primary Key (FClassID)
)
GO
If Exists(Select 1 From Sysobjects WHere Name='GetNewBasicItemList' And xType='P')
Drop Procedure GetNewBasicItemList
GO
Create Procedure GetNewBasicItemList
AS
Declare @ClassID Int
Declare @ModifyTime binary(8)

---1��ͬ���ͻ�
Select @ModifyTime=IsNUll(FModifyTime,0x0000000) From TB_DataSynchLog Where FClassID=1
Set @ModifyTime=IsNUll(@ModifyTime,0x0000000)
Select 1 AS ���,A.FNumber AS �ͻ�����,A.FName AS �ͻ�����,B.FName AS ���۴���,A.FItemID,ISNULL(A.FEmployee,0) AS FEmpID,A.FModifyTime 
From t_Organization A
Left  Join t_Emp B On B.FItemID=A.FEmployee
Where A.FDeleted=0 And A.FModifyTime>@ModifyTime
Order By A.FNumber 

Delete From TB_DataSynchLog Where FClassID=1
Insert Into TB_DataSynchLog
(FClassID,FDataType,FTableName,FDescription,FModifyTime)
Select 1,'�ͻ�','T_Organization','',Max(FModifyTime)
From t_Organization 
Where FDeleted=0

---2��ͬ������
Select @ModifyTime=IsNUll(FModifyTime,0x0000000) From TB_DataSynchLog Where FClassID=2
Set @ModifyTime=IsNUll(@ModifyTime,0x0000000)
--���Ų�ѯ�ű�
Select 2 AS ���,A.FNumber AS ���Ŵ���,A.FName AS ��������,A.FItemID,A.FModifyTime 
From T_Department A
Where A.FDeleted=0 And A.FModifyTime>@ModifyTime
Order By A.FNumber

Delete From TB_DataSynchLog Where FClassID=2
Insert Into TB_DataSynchLog
(FClassID,FDataType,FTableName,FDescription,FModifyTime)
Select 2,'����','T_Department','',Max(FModifyTime)
From T_Emp  
Where FDeleted=0

---3��ͬ��ְԱ
Select @ModifyTime=IsNUll(FModifyTime,0x0000000) From TB_DataSynchLog Where FClassID=3
Set @ModifyTime=IsNUll(@ModifyTime,0x0000000)
--ְԱ��ѯ�ű�
Select 3 AS ���,A.FNumber AS Ա�����,A.FName AS ����,B.FName AS ��������,A.FItemID,IsNull(A.FDepartmentID,0) AS FDeptID,A.FModifyTime 
From T_Emp A
Left  Join t_Department B On B.FItemID=A.FDepartmentID
Where A.FDeleted=0 And A.FModifyTime>@ModifyTime
Order By A.FNumber

Delete From TB_DataSynchLog Where FClassID=3
Insert Into TB_DataSynchLog
(FClassID,FDataType,FTableName,FDescription,FModifyTime)
Select 3,'ְԱ','T_Emp','',Max(FModifyTime)
From T_Emp  
Where FDeleted=0

---4��ͬ������
Select @ModifyTime=IsNUll(FModifyTime,0x0000000) From TB_DataSynchLog Where FClassID=4
Set @ModifyTime=IsNUll(@ModifyTime,0x0000000)
--���ϲ�ѯ�ű�
Select 4 AS ���,A.FNumber AS ���ϱ���,A.FName AS ��������,A.FModel AS ����ͺ�,B.FName AS ��λ,C.FName AS ����,A.FItemID,A.FModifyTime 
From T_ICItem A
Inner Join t_MeasureUnit B On B.FMeasureUnitID=A.FUnitID
Inner Join t_SubMessage C On C.FInterID=A.FErpClsID
Where A.FDeleted=0 And A.FModifyTime>@ModifyTime
Order By A.FNumber

Delete From TB_DataSynchLog Where FClassID=4
Insert Into TB_DataSynchLog
(FClassID,FDataType,FTableName,FDescription,FModifyTime)
Select 4,'��Ʒ','T_ICItem','',Max(FModifyTime)
From T_ICItem 
Where FDeleted=0

---5��ͬ���ֿ�
Select @ModifyTime=FModifyTime From TB_DataSynchLog Where FClassID=5
Set @ModifyTime=IsNUll(@ModifyTime,0x0000000)
--�ֿ��ѯ�ű�
Select 5 AS ���,A.FNumber AS �ֿ����,A.FName AS �ֿ�����,A.FMRPAvail AS ������,A.FItemID,A.FModifyTime 
From T_Stock A
Where A.FDeleted=0 And A.FModifyTime>@ModifyTime
Order By A.FNumber

Delete From TB_DataSynchLog Where FClassID=5
Insert Into TB_DataSynchLog
(FClassID,FDataType,FTableName,FDescription,FModifyTime)
Select 5,'�ֿ�','T_Stock','',Max(FModifyTime)
From T_Stock 
Where FDeleted=0

---6��ͬ����Ӧ��
Select @ModifyTime=IsNUll(FModifyTime,0x0000000) From TB_DataSynchLog Where FClassID=8
Set @ModifyTime=IsNUll(@ModifyTime,0x0000000)
--��Ӧ�̲�ѯ�ű�
Select 8 AS ���,A.FNumber AS ��Ӧ�̴���,A.FName AS ��Ӧ������,A.FItemID,A.FModifyTime 
From t_Supplier A
Where A.FDeleted=0 And A.FModifyTime>@ModifyTime
Order By A.FNumber

Delete From TB_DataSynchLog Where FClassID=8
Insert Into TB_DataSynchLog
(FClassID,FDataType,FTableName,FDescription,FModifyTime)
Select 8,'��Ӧ��','t_Supplier','',Max(FModifyTime)
From t_Supplier 
Where FDeleted=0


---7��ͬ���ұ�
Select @ModifyTime=IsNUll(FModifyTime,0x0000000) From TB_DataSynchLog Where FClassID=4000001
Set @ModifyTime=IsNUll(@ModifyTime,0x0000000)
--��Ӧ�̲�ѯ�ű�
Select 4000001 AS ���,A.FNumber AS ��Ӧ�̴���,A.FName AS ��Ӧ������,A.FCurrencyID,A.FModifyTime 
From t_Currency A
Where A.FCurrencyID<>0 And A.FModifyTime>@ModifyTime
Order By A.FNumber

Delete From TB_DataSynchLog Where FClassID=4000001
Insert Into TB_DataSynchLog
(FClassID,FDataType,FTableName,FDescription,FModifyTime)
Select 4000001,'�ұ�','t_Currency','',Max(FModifyTime)
From t_Supplier 
Where FCurrencyID<>0


--8�����Ϸ���
Select FItemID,FNumber,FName,FParentID,FModifyTime
From t_Item 
Where FItemClassID=4 And FDetail=0 And FDeleted=0

Select FItemID as id,FNumber as number,FName as name,FParentID as parentId,FModifyTime as modifyTime
From t_Item 
Where FItemClassID=4 And FDetail=0 And FDeleted=0



---9���ֿ����ѯ
Select C.FName AS �ֿ�,D.FName AS ��λ, B.FNumber AS ���ϱ���,B.FName AS ���ϱ���,ISNULL(B.FModel,'') AS ����ͺ�,E.FName AS ��������,ISNULL(A.FBatchNo,'') AS ����,
F.FName AS ��λ,A.FQty/F.FCoefficient AS ����
From ICInventory A
Inner Join t_ICItem B On B.FItemID=A.FItemID
Inner Join t_Stock C On C.FItemID=A.FStockID
Left  Join t_StockPlace D On D.FSPID=A.FStockPlaceID
Left  Join t_AuxItem E On E.FItemID=A.FAuxPropID
Inner Join t_MeasureUnit F On F.FMeasureUnitID=B.FStoreUnitID
Where C.FName Like '%�ֿ����%'
And B.FNumber+B.FName+ISNULL(B.FModel,'') Like  '%�ֿ����%'


GO