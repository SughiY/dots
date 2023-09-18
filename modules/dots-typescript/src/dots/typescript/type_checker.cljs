(ns dots.typescript.type-checker)

(defn get-type-of-symbol-at-location
  ^Type [^TypeChecker type-checker ^Symbol symbol ^Node node]
  (.getTypeOfSymbolAtLocation type-checker symbol node))

(defn get-declared-type-of-symbol
  ^Type [^TypeChecker type-checker ^Symbol sym]
  (.getDeclaredTypeOfSymbol type-checker sym))

(defn get-properties-of-type
  ^"Symbol[]" [^TypeChecker type-checker ^Symbol sym]
  (.getPropertiesOfType type-checker sym))

;;getPropertyOfType(type: Type, propertyName: string): Symbol | undefined;
;;getPrivateIdentifierPropertyOfType(leftType: Type, name: string, location: Node): Symbol | undefined;
;;getIndexInfoOfType(type: Type, kind: IndexKind): IndexInfo | undefined;
;;getIndexInfosOfType(type: Type): readonly IndexInfo[];
;;getSignaturesOfType(type: Type, kind: SignatureKind): readonly Signature[];
;;getIndexTypeOfType(type: Type, kind: IndexKind): Type | undefined;
;;getBaseTypes(type: InterfaceType): BaseType[];
;;getBaseTypeOfLiteralType(type: Type): Type;
;;getWidenedType(type: Type): Type;
;;getReturnTypeOfSignature(signature: Signature): Type;
;;getNullableType(type: Type, flags: TypeFlags): Type;
;;getNonNullableType(type: Type): Type;
;;getTypeArguments(type: TypeReference): readonly Type[];
;;/** Note that the resulting nodes cannot be checked. */
;;typeToTypeNode(type: Type, enclosingDeclaration: Node | undefined, flags: NodeBuilderFlags | undefined): TypeNode | undefined;
;;/** Note that the resulting nodes cannot be checked. */
;;signatureToSignatureDeclaration(signature: Signature, kind: SyntaxKind, enclosingDeclaration: Node | undefined, flags: NodeBuilderFlags | undefined): SignatureDeclaration & {
        ;;typeArguments?: NodeArray<TypeNode>;
;;} | undefined;
;;/** Note that the resulting nodes cannot be checked. */
;;indexInfoToIndexSignatureDeclaration(indexInfo: IndexInfo, enclosingDeclaration: Node | undefined, flags: NodeBuilderFlags | undefined): IndexSignatureDeclaration | undefined;
;;/** Note that the resulting nodes cannot be checked. */
;;symbolToEntityName(symbol: Symbol, meaning: SymbolFlags, enclosingDeclaration: Node | undefined, flags: NodeBuilderFlags | undefined): EntityName | undefined;
;;/** Note that the resulting nodes cannot be checked. */
;;symbolToExpression(symbol: Symbol, meaning: SymbolFlags, enclosingDeclaration: Node | undefined, flags: NodeBuilderFlags | undefined): Expression | undefined;
;;/** Note that the resulting nodes cannot be checked. */
;;symbolToTypeParameterDeclarations(symbol: Symbol, enclosingDeclaration: Node | undefined, flags: NodeBuilderFlags | undefined): NodeArray<TypeParameterDeclaration> | undefined;
;;/** Note that the resulting nodes cannot be checked. */
;;symbolToParameterDeclaration(symbol: Symbol, enclosingDeclaration: Node | undefined, flags: NodeBuilderFlags | undefined): ParameterDeclaration | undefined;
;;/** Note that the resulting nodes cannot be checked. */
;;typeParameterToDeclaration(parameter: TypeParameter, enclosingDeclaration: Node | undefined, flags: NodeBuilderFlags | undefined): TypeParameterDeclaration | undefined;
;;getSymbolsInScope(location: Node, meaning: SymbolFlags): Symbol[];

(defn get-symbol-at-location
  ^"Symbol | undefined" [^TypeChecker type-checker ^Node node]
  (.getSymbolAtLocation type-checker node))

;;getSymbolsOfParameterPropertyDeclaration(parameter: ParameterDeclaration, parameterName: string): Symbol[];
;;/**
;;* The function returns the value (local variable) symbol of an identifier in the short-hand property assignment.
;;* This is necessary as an identifier in short-hand property assignment can contains two meaning: property name and property value.
;;*/
;;getShorthandAssignmentValueSymbol(location: Node | undefined): Symbol | undefined;
;;getExportSpecifierLocalTargetSymbol(location: ExportSpecifier | Identifier): Symbol | undefined;
;;/**
;;* If a symbol is a local symbol with an associated exported symbol, returns the exported symbol.
;;* Otherwise returns its input.
;;* For example, at `export type T = number;`:
;;*     - `getSymbolAtLocation` at the location `T` will return the exported symbol for `T`.
;;*     - But the result of `getSymbolsInScope` will contain the *local* symbol for `T`, not the exported symbol.
;;*     - Calling `getExportSymbolOfSymbol` on that local symbol will return the exported symbol.
;;*/
;;getExportSymbolOfSymbol(symbol: Symbol): Symbol;
;;getPropertySymbolOfDestructuringAssignment(location: Identifier): Symbol | undefined;
;;getTypeOfAssignmentPattern(pattern: AssignmentPattern): Type;
;;getTypeAtLocation(node: Node): Type;
;;getTypeFromTypeNode(node: TypeNode): Type;
;;signatureToString(signature: Signature, enclosingDeclaration?: Node, flags?: TypeFormatFlags, kind?: SignatureKind): string;
;;typeToString(type: Type, enclosingDeclaration?: Node, flags?: TypeFormatFlags): string;

(defn symbol-to-string
  ([^TypeChecker type-checker symbol]
   (.symbolToString type-checker symbol))
  ([^TypeChecker type-checker symbol enclosing-declaration]
   (.symbolToString type-checker symbol enclosing-declaration))
  ([^TypeChecker type-checker symbol enclosing-declaration meaning]
   (.symbolToString type-checker symbol enclosing-declaration meaning))
  ([^TypeChecker type-checker symbol enclosing-declaration meaning flags]
   (.symbolToString type-checker symbol enclosing-declaration meaning flags)))

;;typePredicateToString(predicate: TypePredicate, enclosingDeclaration?: Node, flags?: TypeFormatFlags): string;

(defn get-fully-qualified-name [^TypeChecker type-checker ^Symbol sym]
  (.getFullyQualifiedName type-checker sym))

;;getAugmentedPropertiesOfType(type: Type): Symbol[];
;;getRootSymbols(symbol: Symbol): readonly Symbol[];
;;getSymbolOfExpando(node: Node, allowDeclaration: boolean): Symbol | undefined;
;;getContextualType(node: Expression): Type | undefined;
;;/**
;;* returns unknownSignature in the case of an error.
;;* returns undefined if the node is not valid.
;;* @param argumentCount Apparent number of arguments, passed in case of a possibly incomplete call. This should come from an ArgumentListInfo. See `signatureHelp.ts`.
;;*/
;;getResolvedSignature(node: CallLikeExpression, candidatesOutArray?: Signature[], argumentCount?: number): Signature | undefined;
;;getSignatureFromDeclaration(declaration: SignatureDeclaration): Signature | undefined;
;;isImplementationOfOverload(node: SignatureDeclaration): boolean | undefined;
;;isUndefinedSymbol(symbol: Symbol): boolean;
;;isArgumentsSymbol(symbol: Symbol): boolean;
;;isUnknownSymbol(symbol: Symbol): boolean;
;;getConstantValue(node: EnumMember | PropertyAccessExpression | ElementAccessExpression): string | number | undefined;
;;isValidPropertyAccess(node: PropertyAccessExpression | QualifiedName | ImportTypeNode, propertyName: string): boolean;
;;/** Follow all aliases to get the original symbol. */
;;getAliasedSymbol(symbol: Symbol): Symbol;
;;/** Follow a *single* alias to get the immediately aliased symbol. */
;;getImmediateAliasedSymbol(symbol: Symbol): Symbol | undefined;

(defn get-exports-of-module
  ^"Symbol[]" [^TypeChecker type-checker ^Symbol module-symbol]
  (.getExportsOfModule type-checker module-symbol))

;;getJsxIntrinsicTagNamesAt(location: Node): Symbol[];
;;isOptionalParameter(node: ParameterDeclaration): boolean;
;;getAmbientModules(): Symbol[];
;;tryGetMemberInModuleExports(memberName: string, moduleSymbol: Symbol): Symbol | undefined;
;;getApparentType(type: Type): Type;
;;getBaseConstraintOfType(type: Type): Type | undefined;
;;getDefaultFromTypeParameter(type: Type): Type | undefined;
;;getTypePredicateOfSignature(signature: Signature): TypePredicate | undefined;
;;/**
;;* Depending on the operation performed, it may be appropriate to throw away the checker
;;* if the cancellation token is triggered. Typically, if it is used for error checking
;;* and the operation is cancelled, then it should be discarded, otherwise it is safe to keep.
;;*/
;;runWithCancellationToken<T>(token: CancellationToken, cb: (checker: TypeChecker) => T): T;
